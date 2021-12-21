package com.pjj.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 潘俊杰
 * @date 2021年09月26日 14:41
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class UserTooManyException extends RuntimeException{
    public UserTooManyException() {
        super();
    }

    public UserTooManyException(String message) {
        super(message);
    }
}
