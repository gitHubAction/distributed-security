package com.seven.core.base.response;

import com.seven.core.base.response.BussinessResponseAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName:    ResponseEnum
 * Package:    com.seven.core.base.exception
 * Datetime:    2020/4/30   11:25
 * Author:   zsh
 * Description:
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum implements BussinessResponseAssert {

    BAD_PRINCIPAL(7001,"无效的认证"),
    PRINCIPAL_NOT_FOUND(7002,"认证信息未找到");


    private int code;

    private String msg;

}
