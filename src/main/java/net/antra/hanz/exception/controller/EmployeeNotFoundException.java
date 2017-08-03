package net.antra.hanz.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hanzheng on 8/1/17.
 */

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Employee not found!")
public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
