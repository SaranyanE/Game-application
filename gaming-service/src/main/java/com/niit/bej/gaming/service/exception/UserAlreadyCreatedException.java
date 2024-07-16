package com.niit.bej.gaming.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "user already exists in the database!")
public class UserAlreadyCreatedException extends Exception {
    public UserAlreadyCreatedException(String message) {
        super(message);
    }
}
