package com.digitalhouse.tpfinal.patient.model.domain;

import com.digitalhouse.tpfinal.shared.model.domain.Address;
import lombok.Builder;
import lombok.With;

import java.time.LocalDate;

@Builder
@With
public record Patient(
        Long id,
        String lastName,
        String firstName,
        Address address,
        String dni,
        LocalDate createdDate
) {
    public Patient copy( Patient patient ) {
        return this.withId( patient.id() )
                   .withLastName( patient.lastName() )
                   .withFirstName( patient.firstName() )
                   .withAddress( patient.address() )
                   .withDni( patient.dni() );
    }
}
