package com.pisces.platform.user.exception;

import java.io.Serial;

/**
 * 用户异常
 *
 * @author jason
 * @date 2022/12/07
 */
public class UserException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 2083330054770216394L;

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }
}
