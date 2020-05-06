package com.seven.core.base.exception;

import com.seven.core.base.response.IResponseEnum;

import java.text.MessageFormat;

/**
 * ClassName:    BussinessExceptionAssert
 * Package:    com.seven.core.base.exception
 * Datetime:    2020/4/30   11:08
 * Author:   zsh
 * Description:
 */
public interface BussinessExceptionAssert extends IResponseEnum,Assert {

    @Override
    default BaseException newException(Object... args){
        String msg = MessageFormat.format(this.getMsg(), args);
        return new BusinessException(this,args,msg);
    }

    @Override
    default BaseException newException(Throwable t,Object... args){
        String msg = MessageFormat.format(this.getMsg(), args);
        return new BusinessException(this,args,msg,t);
    }
}
