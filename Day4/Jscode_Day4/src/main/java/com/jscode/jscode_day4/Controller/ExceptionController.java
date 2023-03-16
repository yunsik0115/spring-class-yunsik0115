package com.jscode.jscode_day4.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public String handleException(IllegalArgumentException e){
        return e.getMessage();
    }

    @ExceptionHandler
    public String handleException(IllegalStateException e){
        return e.getMessage();
    }

}
