package com.pjj.exception;

/**
 * @author 潘俊杰
 * @date 2021年09月04日 10:28
 */
public class NameException extends MyUserException{
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
