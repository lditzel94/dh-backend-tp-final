package com.digitalhouse.tpfinal.dentist.model.dto;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import lombok.Builder;

@Builder
@Deprecated(forRemoval = true)
public record DentistResponse(
        Long id,
        Long license,
        String lastName,
        String firstName
) {
    public static DentistResponse from( Dentist dentist ) {
        return DentistResponse.builder()
                              .id( dentist.id() )
                              .license( dentist.license() )
                              .firstName( dentist.firstName() )
                              .lastName( dentist.lastName() )
                              .build();
    }
}
