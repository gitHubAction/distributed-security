package com.seven.distributed.order.controller;

import com.seven.core.base.exception.BaseException;
import com.seven.core.base.response.ResponseEnum;
import com.seven.distributed.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zhangsh
 * @Date: 2020/4/16 15:01
 * @Version 1.0
 * Description
 */
@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping("sayHello")
    @PreAuthorize("hasAnyAuthority('r1')")
    public String order(String name, HttpServletRequest request){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        orderService.selectOrder();
        String header = request.getHeader("json-token");
        return "hello "+name+"  "+principal+"   "+header;
    }
}
