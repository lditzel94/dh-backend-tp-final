package com.digitalhouse.tpfinal.dentist.model.dto;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;

public record DentistRequest(
        Long license,
        String lastName,
        String firstName
) {
    public Dentist toDomain() {
        return Dentist.builder()
                      .license( license )
                      .firstName( firstName )
                      .lastName( lastName )
                      .build();
    }
}
