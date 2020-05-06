package com.seven.core.base.response;

import com.seven.core.base.exception.BaseException;
import com.seven.core.base.exception.BusinessException;
import com.seven.core.base.sevenAssert.SevenAssert;

import java.text.MessageFormat;

/**
 * ClassName:    BussinessExceptionAssert
 * Package:    com.seven.core.base.exception
 * Datetime:    2020/4/30   11:08
 * Author:   zsh
 * Description:
 */
public interface BussinessResponseAssert extends IResponse, SevenAssert {

    @Override
    default BaseException newException(Object... args){
        String msg = MessageFormat.format(this.getMsg(), args);
        return new BusinessException(this,args,msg);
    }

    @Override
    default BaseException newExceptionWithThrowable(Throwable t,Object... args){
        String msg = MessageFormat.format(this.getMsg(), args);
        return new BusinessException(this,args,msg,t);
    }
}
