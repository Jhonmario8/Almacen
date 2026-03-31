package com.example.onix.exceptions;


import org.springframework.http.HttpStatus;


public class InvalidCredentialsException extends BaseApplicationException{

    public InvalidCredentialsException(String message){
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus(){
        return HttpStatus.UNAUTHORIZED;
    }
}
