package org.example.lab3.exception;

import org.springframework.http.HttpStatus;

public class ValidatorException extends ApiException{
    public ValidatorException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
