package com.digitalhouse.tpfinal.dentist.model.dto;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import lombok.Builder;

@Builder
public record DentistResponse(
        Long license,
        String lastName,
        String firstName
) {
    public static DentistResponse from( Dentist dentist ) {
        return DentistResponse.builder()
                              .license( dentist.license() )
                              .firstName( dentist.firstName() )
                              .lastName( dentist.lastName() )
                              .build();
    }
}
