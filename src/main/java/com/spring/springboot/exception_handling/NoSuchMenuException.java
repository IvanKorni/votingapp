package com.spring.springboot.exception_handling;

public class NoSuchMenuException extends RuntimeException{

    public NoSuchMenuException(String message) {
        super(message);
    }
}
