package com.digitalhouse.tpfinal.dentist.controller;

import com.digitalhouse.tpfinal.dentist.model.dto.DentistDTO;
import com.digitalhouse.tpfinal.dentist.model.error.DentistNotFoundException;
import com.digitalhouse.tpfinal.dentist.service.DentistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@Slf4j
@RequiredArgsConstructor
@RequestMapping( "/dentists" )
@RestController
@CrossOrigin
class DentistController {
    private final DentistService service;

    @GetMapping
    List<DentistDTO.Response.Public> findAll() {
        log.info( "Finding dentists" );
        return service.findAll()
                      .stream()
                      .map( DentistDTO.Response.Public::from )
                      .toList();
    }

    @GetMapping( "/{id}" )
    DentistDTO.Response.Public findBy( @PathVariable Long id ) throws DentistNotFoundException {
        return service.findBy( id )
                      .map( DentistDTO.Response.Public::from )
                      .orElseThrow( DentistNotFoundException::new );
    }

    @PostMapping
    @ResponseStatus( CREATED )
    DentistDTO.Response.Public create( @Valid @RequestBody DentistDTO.Request.Create dentistRequest ) throws RuntimeException {
        return service.create( dentistRequest.toDomain() )
                      .map( DentistDTO.Response.Public::from )
                      .orElseThrow( RuntimeException::new );
    }

    @DeleteMapping( "/{id}" )
    @ResponseStatus( NO_CONTENT )
    void delete( @PathVariable Long id ) {
        service.deleteBy( id );
    }
}
