package com.digitalhouse.tpfinal.patient.model.entity;

import com.digitalhouse.tpfinal.patient.model.domain.Patient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table( name = "PATIENT" )
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity {
    @Id
    @GeneratedValue( strategy = IDENTITY )
    private Long id;
    private String lastName;
    private String firstName;
    private String address; //TODO: refactor to Address object
    private String dni;
    private String createdDate;//TODO: refactor to some timestamp type

    public Patient toDomain() {
        return Patient.builder()
                      .id( id )
                      .lastName( lastName )
                      .firstName( firstName )
                      .address( address )
                      .dni( dni )
                      .createdDate( createdDate )
                      .build();
    }

    public static PatientEntity from( Patient patient ) {
        return new PatientEntity(
                patient.id(),
                patient.lastName(),
                patient.firstName(),
                patient.address(),
                patient.dni(),
                patient.createdDate()
        );
    }
}
