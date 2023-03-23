package com.digitalhouse.tpfinal.patient.model.dto;

import com.digitalhouse.tpfinal.patient.model.domain.Patient;
import com.digitalhouse.tpfinal.shared.model.domain.Address;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

public enum PatientDTO {
    ;

    public enum Request {
        ;

        public record Create(
                @NotNull String lastName,
                @NotNull String firstName,
                @NotNull Address address,
                @NotNull String dni
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

        @Builder
        public record Update(
                @NotNull
                Long id,
                String lastName,
                String firstName,
                Address address,
                String dni
        ) {
            public Patient toDomain() {
                return Patient.builder()
                              .id( id )
                              .lastName( lastName )
                              .firstName( firstName )
                              .address( address )
                              .dni( dni )
                              .build();
            }
        }
    }

    public enum Response {
        ;

        @Builder
        public record Public(
                Long id,
                String lastName,
                String firstName,
                String address,
                String dni,
                LocalDate createdDate
        ) {
            public static Public from( Patient patient ) {
                var address = String.format( "%s, %d", patient.address().street(), patient.address().number() );
                return Public.builder()
                             .id( patient.id() )
                             .lastName( patient.lastName() )
                             .firstName( patient.firstName() )
                             .address( address )
                             .dni( patient.dni() )
                             .createdDate( patient.createdDate() )
                             .build();
            }
        }
    }
}
