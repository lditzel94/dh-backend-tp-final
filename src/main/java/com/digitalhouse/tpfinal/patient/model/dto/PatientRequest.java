package com.digitalhouse.tpfinal.patient.model.dto;

import com.digitalhouse.tpfinal.patient.model.domain.Patient;

import java.time.LocalDate;

public record PatientRequest(
        String lastName,
        String firstName,
        String address, //TODO: refactor to Address object
        String dni
) {

    public Patient toDomain() {
        return Patient.builder()
                      .lastName( lastName )
                      .firstName( firstName )
                      .address( address )
                      .dni( dni )
                      .createdDate( LocalDate.now() )
                      .build();
    }
}
