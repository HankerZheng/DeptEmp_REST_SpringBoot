package net.antra.hanz.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hanzheng on 8/1/17.
 */

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Department not found!")
public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException(String message) {
        super(message);
    }

}
