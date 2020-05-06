package com.seven.core.base.exception;

/**
 * ClassName:    Assert
 * Package:    com.seven.core.base.exception
 * Datetime:    2020/4/30   11:27
 * Author:   zsh
 * Description:
 */
public interface Assert {

    default void assertNotNull(Object... obj) throws BaseException {
        if(obj == null){
            throw newException(obj);
        }
    }

    default void assertNotNull(Object obj,Object... args) throws BaseException {
        if(obj == null){
            throw newException(args);
        }
    }

    BaseException newException(Object... obj);

    BaseException newException(Throwable t,Object... args);
}
