package com.pjj.exception;

/**
 * @author 潘俊杰
 * @date 2021年09月04日 10:28
 */
public class AgeException extends MyUserException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
