package com.niit.bej.gaming.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Game not found in the database")
public class GameNotFoundException extends Exception {
    public GameNotFoundException(String message) {
        super(message);
    }
}
