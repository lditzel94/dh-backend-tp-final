package com.digitalhouse.tpfinal.dentist.model.entity;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
@Table( name = "DENTIST" )
@NoArgsConstructor
@AllArgsConstructor
public class DentistEntity {
    @Id
    @GeneratedValue( strategy = IDENTITY )
    @Column( name = "dentist_id" )
    private Long id;

    private Long license;

    private String lastName;

    private String firstName;

    public Dentist toDomain() {
        return Dentist.builder()
                      .id( id )
                      .license( license )
                      .firstName( firstName )
                      .lastName( lastName )
                      .build();
    }

    public static DentistEntity from( Dentist dentist ) {
        return new DentistEntity(
                dentist.id(),
                dentist.license(),
                dentist.lastName(),
                dentist.firstName()
        );
    }
}
