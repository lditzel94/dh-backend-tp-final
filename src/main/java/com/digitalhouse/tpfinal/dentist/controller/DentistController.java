package com.digitalhouse.tpfinal.dentist.controller;

import com.digitalhouse.tpfinal.dentist.model.dto.DentistRequest;
import com.digitalhouse.tpfinal.dentist.model.dto.DentistResponse;
import com.digitalhouse.tpfinal.dentist.model.error.DentistNotFoundException;
import com.digitalhouse.tpfinal.dentist.service.DentistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping( "/dentists" )
@RestController
class DentistController {
    private final DentistService service;

    @GetMapping( "/{license}" )
    DentistResponse findBy( @PathVariable Long license ) throws DentistNotFoundException {
        var dentist = service.findBy( license );
        return DentistResponse.from( dentist );
    }

    @PostMapping
    DentistResponse create( @Valid @RequestBody DentistRequest dentistRequest ) {
        var created = service.create( dentistRequest.toDomain() );
        return DentistResponse.from( created );
    }
}
