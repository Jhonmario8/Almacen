package com.example.onix.exceptions;

import org.springframework.http.HttpStatus;

public abstract class BaseApplicationException extends RuntimeException{

    private long timestamp;

    public BaseApplicationException(String message){
        super(message);
        this.timestamp = System.currentTimeMillis();
    }
    public abstract HttpStatus getHttpStatus();
}
