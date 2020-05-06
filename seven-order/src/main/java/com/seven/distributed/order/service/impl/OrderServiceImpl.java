package com.seven.distributed.order.service.impl;

import com.seven.core.base.response.ResponseEnum;
import com.seven.distributed.order.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * ClassName:    OrderServiceImpl
 * Package:    com.seven.distributed.order.service.impl
 * Datetime:    2020/5/6   16:22
 * Author:   zsh
 * Description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public String selectOrder(){
        ResponseEnum.PRINCIPAL_NOT_FOUND.assertNotNull(null);
        return null;
    }
}
