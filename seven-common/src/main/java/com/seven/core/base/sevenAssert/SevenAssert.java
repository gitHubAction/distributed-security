package com.seven.core.base.sevenAssert;

import com.seven.core.base.exception.BaseException;

/**
 * ClassName:    Assert
 * Package:    com.seven.core.base.exception
 * Datetime:    2020/4/30   11:27
 * Author:   zsh
 * Description:
 */
public interface SevenAssert {

    BaseException newException(Object... obj);

    BaseException newExceptionWithThrowable(Throwable t,Object... args);

    default void assertNotNull(Object... obj){
        if(obj == null){
            throw newException(obj);
        }
    }

    default void assertNotNullWithArgs(Object obj,Object... args) {
        if(obj == null){
            throw newExceptionWithThrowable(null,args);
        }
    }

}
