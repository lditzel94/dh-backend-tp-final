package com.digitalhouse.tpfinal.dentist.model.dto;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

public enum DentistDTO {
    ;

    public enum Request {
        ;

        public record Create(
                @NotNull @Positive
                Long license,
                @NotBlank String lastName,
                @NotBlank String firstName
        ) {
            public Dentist toDomain() {
                return Dentist.builder()
                              .license( license )
                              .firstName( firstName )
                              .lastName( lastName )
                              .build();
            }
        }

        @Builder
        public record Update(
                @NotNull Long id,
                Long license,
                String lastName,
                String firstName
        ) {
        }
    }

    public enum Response {
        ;

        @Builder
        public record Public(
                Long id,
                Long license,
                String lastName,
                String firstName
        ) {
            public static Public from( Dentist dentist ) {
                return Public.builder()
                             .id( dentist.id() )
                             .license( dentist.license() )
                             .firstName( dentist.firstName() )
                             .lastName( dentist.lastName() )
                             .build();
            }
        }
    }
}
