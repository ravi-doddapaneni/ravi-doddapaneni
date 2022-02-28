package org.neobank.profile.exceptions;

import com.google.common.flogger.StackSize;
import lombok.extern.flogger.Flogger;
import org.neobank.profile.exceptions.model.ErrorMessage;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Flogger
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> HandleAnyException(Exception ex)
    {
        log.atSevere().withStackTrace(StackSize.SMALL).withCause(ex).log("Exception occurred");
        return new ResponseEntity(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
