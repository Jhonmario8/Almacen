package com.example.onix.exceptions;


import org.springframework.http.HttpStatus;


public class UnauthorizedException extends BaseApplicationException{

    public UnauthorizedException(String message){
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus(){
        return HttpStatus.UNAUTHORIZED;
    }
}
