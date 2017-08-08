package net.antra.hanz.config;

import net.antra.hanz.exception.ErrorTestException;
import net.antra.hanz.exception.OtherException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by hanzheng on 8/1/17.
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @ResponseStatus(code=HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(ErrorTestException.class)
    public String handlerUnexpectedException(Exception e) {
        return e.getMessage() + "\n" + messageSource.getMessage("error", null, Locale.CHINESE);
    }

    @ResponseStatus(code=HttpStatus.CONFLICT)
    @ExceptionHandler(OtherException.class)
    public String handleUncheckedException(Exception e) {
        return e.getMessage();
    }
}
