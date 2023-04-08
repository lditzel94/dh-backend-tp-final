package com.digitalhouse.tpfinal.patient.controller;

import com.digitalhouse.tpfinal.patient.model.dto.PatientDTO;
import com.digitalhouse.tpfinal.patient.model.error.PatientNotFoundException;
import com.digitalhouse.tpfinal.patient.service.PatientService;
import com.digitalhouse.tpfinal.shared.model.error.ServerError;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequiredArgsConstructor
@RequestMapping( "/api/patients" )
@RestController
@CrossOrigin
public class PatientController {
    private final PatientService service;

    @GetMapping
    List<PatientDTO.Response.Public> findAll() {
        return service.findAll()
                      .stream()
                      .map( PatientDTO.Response.Public::from )
                      .toList();
    }

    @GetMapping( "/{id}" )
    PatientDTO.Response.Public findBy( @PathVariable Long id ) {
        return service.findBy( id )
                      .map( PatientDTO.Response.Public::from )
                      .orElseThrow( PatientNotFoundException::new );
    }

    @PostMapping
    @ResponseStatus( CREATED )
    PatientDTO.Response.Public create( @Valid @RequestBody
                                       PatientDTO.Request.Create patientRequest ) {
        return service.create( patientRequest.toDomain() )
                      .map( PatientDTO.Response.Public::from )
                      .orElseThrow( ServerError::new );
    }

    @PatchMapping
    PatientDTO.Response.Public update( @RequestBody PatientDTO.Request.Update patientRequest ) {
        return service.update( patientRequest.toDomain() )
                      .map( PatientDTO.Response.Public::from )
                      .orElseThrow( PatientNotFoundException::new );
    }

    @DeleteMapping( "/{id}" )
    @ResponseStatus( NO_CONTENT )
    void delete( @PathVariable Long id ) {
        service.deleteBy( id );
    }
}
