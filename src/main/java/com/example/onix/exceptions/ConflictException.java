package com.example.onix.exceptions;

import org.springframework.http.HttpStatus;

public class ConflictException extends BaseApplicationException{
    public ConflictException(String message){
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus(){
        return HttpStatus.CONFLICT;
    }
}
