package com.digitalhouse.tpfinal.shared.error;

import com.digitalhouse.tpfinal.shared.model.error.ServerError;
import com.digitalhouse.tpfinal.shared.model.error.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler( UserAlreadyExistsException.class )
    ProblemDetail handleUserAlreadyExistsException( UserAlreadyExistsException e ) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail( HttpStatus.BAD_REQUEST, e.getMessage() );
        problemDetail.setTitle( "User already exists" );
        return problemDetail;
    }

    @ExceptionHandler( ServerError.class )
    ProblemDetail handleServerError( ServerError e ) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail( HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        problemDetail.setTitle( "Unexpected error occur" );
        return problemDetail;
    }
}
