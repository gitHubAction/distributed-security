package com.seven.core.base.exception;

import com.seven.core.base.response.IResponseEnum;

/**
 * ClassName:    BusinessException
 * Package:    com.seven.core.base.exception
 * Datetime:    2020/4/30   10:59
 * Author:   zsh
 * Description:
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 4193584474229424491L;

    public BusinessException(IResponseEnum responseEnum, Object[] args, String msg, Throwable cause) {
        super(responseEnum, args, msg, cause);
    }

    public BusinessException(IResponseEnum responseEnum, Object[] args, String msg) {
        super(responseEnum, args, msg);
    }
}
