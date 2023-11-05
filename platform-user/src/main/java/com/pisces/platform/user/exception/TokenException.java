package com.pisces.platform.user.exception;

import com.pisces.framework.core.exception.BaseException;

public class TokenException extends BaseException {
    
    public TokenException(Enum<?> key, Object... args) {
        super(key, args);
    }
}
