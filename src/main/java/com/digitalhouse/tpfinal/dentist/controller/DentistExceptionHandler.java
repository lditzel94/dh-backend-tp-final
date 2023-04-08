package com.digitalhouse.tpfinal.dentist.controller;

import com.digitalhouse.tpfinal.dentist.model.error.DentistNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class DentistExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler( DentistNotFoundException.class )
    ProblemDetail handleUserAlreadyExistsException( DentistNotFoundException e ) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail( HttpStatus.NOT_FOUND, e.getMessage() );
        problemDetail.setTitle( "Dentist not found" );
        return problemDetail;
    }
}
