package com.pjj.exception;

/**
 * @author 潘俊杰
 * @date 2021年08月30日 19:53
 */
public class NotEnoughException extends RuntimeException {
    public NotEnoughException() {
        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
