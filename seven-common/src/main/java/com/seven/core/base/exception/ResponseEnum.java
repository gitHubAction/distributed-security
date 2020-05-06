package com.seven.core.base.exception;

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
public enum ResponseEnum implements BussinessExceptionAssert {

    BAD_LINCENCE_TYPE(7001,"123"),
    INVALID_LINCENCE(7002,"456");


    private int code;

    private String msg;

}
