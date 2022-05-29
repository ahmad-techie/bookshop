package org.meritamerica.bookshop.exceptions;


import org.meritamerica.bookshop.model.CustomResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CustomResponseBody handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new CustomResponseBody("400", LocalDateTime.now(), e.getLocalizedMessage());
    }


}
