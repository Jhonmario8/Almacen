package com.example.onix.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseApplicationException{

    public NotFoundException(String message){
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus(){
        return HttpStatus.NOT_FOUND;
    }
}

