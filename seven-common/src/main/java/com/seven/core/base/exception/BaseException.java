package com.seven.core.base.exception;

import com.seven.core.base.response.IResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName:    BaseException
 * Package:    com.seven.core.base.exception
 * Datetime:    2020/4/30   10:59
 * Author:   zsh
 * Description: 基础异常类
 */
@Data
@AllArgsConstructor
@ToString
public class BaseException extends Throwable implements Serializable {


    private static final long serialVersionUID = 4381259240958026998L;

    private int code;

    private String msg;

    public BaseException(IResponseEnum responseEnum, Object[] args, String msg) {
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String msg,Throwable t) {
    }

}
