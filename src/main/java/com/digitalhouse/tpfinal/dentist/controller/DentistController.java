package com.digitalhouse.tpfinal.dentist.controller;

import com.digitalhouse.tpfinal.dentist.model.dto.DentistRequest;
import com.digitalhouse.tpfinal.dentist.model.dto.DentistResponse;
import com.digitalhouse.tpfinal.dentist.model.error.DentistNotFoundException;
import com.digitalhouse.tpfinal.dentist.service.DentistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequiredArgsConstructor
@RequestMapping( "/dentists" )
@RestController
class DentistController {
    private final DentistService service;

    @GetMapping
    List<DentistResponse> findAll() {
        return service.findAll()
                      .stream()
                      .map( DentistResponse::from )
                      .toList();
    }

    @GetMapping( "/{license}" )
    DentistResponse findBy( @PathVariable Long license ) throws DentistNotFoundException {
        return service.findBy( license )
                      .map( DentistResponse::from )
                      .orElseThrow( DentistNotFoundException::new );
    }

    @PostMapping
    @ResponseStatus( CREATED )
    DentistResponse create( @Valid @RequestBody DentistRequest dentistRequest ) throws RuntimeException {
        return service.create( dentistRequest.toDomain() )
                      .map( DentistResponse::from )
                      .orElseThrow( RuntimeException::new );
    }

    @DeleteMapping( "/{license}" )
    @ResponseStatus( NO_CONTENT )
    void delete( @PathVariable Long license ) {
        service.deleteBy( license );
    }
}
