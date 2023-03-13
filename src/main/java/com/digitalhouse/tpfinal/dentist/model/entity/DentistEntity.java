package com.digitalhouse.tpfinal.dentist.model.entity;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table( name = "DENTIST" )
@NoArgsConstructor
@AllArgsConstructor
public class DentistEntity {
    @Id
    @GeneratedValue( strategy = IDENTITY )
    private Long id;
    Long license;
    String lastName;
    String firstName;

    public Dentist toDomain() {
        return Dentist.builder()
                      .id( id )
                      .license( license )
                      .firstName( firstName )
                      .lastName( lastName )
                      .build();
    }
}
