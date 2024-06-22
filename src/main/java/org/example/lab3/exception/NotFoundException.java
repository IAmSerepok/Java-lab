package org.example.lab3.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiException{
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
