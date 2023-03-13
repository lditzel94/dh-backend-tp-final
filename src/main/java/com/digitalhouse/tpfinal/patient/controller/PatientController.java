package com.digitalhouse.tpfinal.patient.controller;

import com.digitalhouse.tpfinal.dentist.model.error.DentistNotFoundException;
import com.digitalhouse.tpfinal.patient.model.dto.PatientRequest;
import com.digitalhouse.tpfinal.patient.model.dto.PatientResponse;
import com.digitalhouse.tpfinal.patient.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequiredArgsConstructor
@RequestMapping( "/patients" )
@RestController
public class PatientController {
    private final PatientService service;

    @GetMapping
    List<PatientResponse> findAll() {
        return service.findAll()
                      .stream()
                      .map( PatientResponse::from )
                      .toList();
    }

    @GetMapping( "/{id}" )
    PatientResponse findBy( @PathVariable Long id ) throws DentistNotFoundException {
        return service.findBy( id )
                      .map( PatientResponse::from )
                      .orElseThrow( DentistNotFoundException::new );
    }

    @PostMapping
    @ResponseStatus( CREATED )
    PatientResponse create( @Valid @RequestBody PatientRequest patientRequest ) throws RuntimeException {
        PatientResponse response = PatientResponse.builder().build();

        try {
            var patient = service.create( patientRequest.toDomain() );
            response = PatientResponse.from( patient.get() );
        } catch ( Exception e ) {
            System.out.println( e.getMessage() );
            e.printStackTrace();
        }

        return response;
        //return service.create( patientRequest.toDomain() )
        //              .map( PatientResponse::from )
        //              .orElseThrow( RuntimeException::new );
    }

    @DeleteMapping( "/{id}" )
    @ResponseStatus( NO_CONTENT )
    void delete( @PathVariable Long id ) {
        service.deleteBy( id );
    }
}
