package com.training.faculty.service.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String s) {
        super(s);
    }

    public BadRequestException(Exception e) {
        super(e);
    }
}
