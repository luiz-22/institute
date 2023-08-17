package com.example.institute.exception;

public class BadRequestException extends Exception{
    public BadRequestException(String massage){
        super(massage);
    }
}