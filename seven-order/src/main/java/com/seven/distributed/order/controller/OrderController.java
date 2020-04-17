package com.seven.distributed.order.controller;

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

    @GetMapping("sayHello")
    @PreAuthorize("hasAnyAuthority('r1')")
    public String order(String name, HttpServletRequest request){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String header = request.getHeader("json-token");
        return "hello "+name+"  "+principal+"   "+header;
    }
}
