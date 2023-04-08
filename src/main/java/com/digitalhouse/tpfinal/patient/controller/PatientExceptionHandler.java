package com.digitalhouse.tpfinal.patient.controller;

import com.digitalhouse.tpfinal.patient.model.error.PatientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class PatientExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler( PatientNotFoundException.class )
    ProblemDetail handleUserAlreadyExistsException( PatientNotFoundException e ) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail( HttpStatus.NOT_FOUND, e.getMessage() );
        problemDetail.setTitle( "Patient not found" );
        return problemDetail;
    }
}
