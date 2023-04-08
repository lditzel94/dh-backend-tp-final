package com.digitalhouse.tpfinal.shared.model.error;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException( String message ) {
        super( message );
    }
}
