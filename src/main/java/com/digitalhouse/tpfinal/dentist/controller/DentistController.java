package com.digitalhouse.tpfinal.dentist.controller;

import com.digitalhouse.tpfinal.dentist.model.dto.DentistDTO;
import com.digitalhouse.tpfinal.dentist.model.error.DentistNotFoundException;
import com.digitalhouse.tpfinal.dentist.service.DentistService;
import com.digitalhouse.tpfinal.shared.model.error.ServerError;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequiredArgsConstructor
@RequestMapping( "/api/dentists" )
@RestController
@CrossOrigin
class DentistController {
    private final DentistService service;

    @GetMapping
    List<DentistDTO.Response.Public> findAll() {
        return service.findAll()
                      .stream()
                      .map( DentistDTO.Response.Public::from )
                      .toList();
    }

    @GetMapping( "/{id}" )
    DentistDTO.Response.Public findBy( @PathVariable Long id ) {
        return service.findBy( id )
                      .map( DentistDTO.Response.Public::from )
                      .orElseThrow( DentistNotFoundException::new );
    }

    @PostMapping
    @ResponseStatus( CREATED )
    DentistDTO.Response.Public create( @Valid @RequestBody DentistDTO.Request.Create dentistRequest ) {
        return service.create( dentistRequest.toDomain() )
                      .map( DentistDTO.Response.Public::from )
                      .orElseThrow( ServerError::new );
    }

    @PatchMapping
    DentistDTO.Response.Public update( @RequestBody DentistDTO.Request.Update dentistRequest ) {
        return service.update( dentistRequest.toDomain() )
                      .map( DentistDTO.Response.Public::from )
                      .orElseThrow( DentistNotFoundException::new );
    }

    @DeleteMapping( "/{id}" )
    @ResponseStatus( NO_CONTENT )
    void delete( @PathVariable Long id ) {
        service.deleteBy( id );
    }
}
