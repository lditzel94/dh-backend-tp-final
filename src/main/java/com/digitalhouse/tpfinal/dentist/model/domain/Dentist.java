package com.digitalhouse.tpfinal.dentist.model.domain;

import lombok.Builder;
import lombok.With;

@Builder
@With
public record Dentist(
        Long id,
        Long license,
        String lastName,
        String firstName
) {

    public Dentist copy( Dentist dentist ) {
        return this.withId( dentist.id() )
                   .withLicense( dentist.license() )
                   .withLastName( dentist.lastName() )
                   .withFirstName( dentist.firstName() );
    }
}
