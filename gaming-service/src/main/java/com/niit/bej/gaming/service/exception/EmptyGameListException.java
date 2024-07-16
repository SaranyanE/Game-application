package com.niit.bej.gaming.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "the list is empty!")
public class EmptyGameListException extends Exception {
    public EmptyGameListException(String message) {
        super(message);
    }
}
