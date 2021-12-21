package com.pjj.exception;

/**
 * @author 潘俊杰
 * @date 2021年09月04日 10:27
 */
public class MyUserException extends RuntimeException{
    public MyUserException() {
        super();
    }

    public MyUserException(String message) {
        super(message);
    }
}
