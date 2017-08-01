package net.antra.hanz.config;

import net.antra.hanz.exception.ErrorTestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by hanzheng on 8/1/17.
 */

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(code=HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(ErrorTestException.class)
    public String handlerUnexpectedException(Exception e) {
        return e.getMessage();
    }
}
