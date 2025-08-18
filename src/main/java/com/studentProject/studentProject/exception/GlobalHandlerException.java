package com.studentProject.studentProject.exception;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.studentProject.studentProject.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalHandlerException {
    

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponseDto handleNoSuchElement(NoSuchElementException ex) {
        return new ErrorResponseDto(LocalDateTime.now(), ex.getMessage(), "No additional details");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponseDto handleGeneric(Exception ex) {
        return new ErrorResponseDto(LocalDateTime.now(), "An error occurred " + ex.getMessage(), "No additional details");
    }

}
