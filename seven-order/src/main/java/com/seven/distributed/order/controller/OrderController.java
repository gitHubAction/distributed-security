package com.seven.distributed.order.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String order(String name){
        return "hello "+name;
    }
}
