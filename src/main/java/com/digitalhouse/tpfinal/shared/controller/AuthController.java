package com.digitalhouse.tpfinal.shared.controller;

import com.digitalhouse.tpfinal.shared.model.dto.AuthRequest;
import com.digitalhouse.tpfinal.shared.model.error.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RequestMapping( "/api/auth" )
@RestController
public class AuthController {
    private final UserDetailsManager inMemory;
    private final PasswordEncoder passwordEncoder;

    @PostMapping( "/signup" )
    @ResponseStatus( CREATED )
    public void register( @RequestBody AuthRequest authRequest ) throws UserAlreadyExistsException {
        if ( inMemory.userExists( authRequest.username() ) ) throw new UserAlreadyExistsException( "User already exists" );

        inMemory.createUser( User.withUsername( authRequest.username() )
                                 .password( passwordEncoder.encode( authRequest.password() ) )
                                 .roles( "ADMIN" )
                                 .build() );
    }
}
