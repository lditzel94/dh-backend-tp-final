package com.digitalhouse.tpfinal.patient.model.entity;

import com.digitalhouse.tpfinal.patient.model.domain.Patient;
import com.digitalhouse.tpfinal.shared.model.AddressEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table( name = "PATIENT" )
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity {
    @Id
    @GeneratedValue( strategy = IDENTITY )
    @Column( name = "patient_id" )
    private Long id;

    private String lastName;

    private String firstName;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "address_id" )
    private AddressEntity address;

    private String dni;

    private LocalDate createdDate;

    public Patient toDomain() {
        return Patient.builder()
                      .id( id )
                      .lastName( lastName )
                      .firstName( firstName )
                      .address( address.toDomain() )
                      .dni( dni )
                      .createdDate( createdDate )
                      .build();
    }

    public static PatientEntity from( Patient patient ) {
        return new PatientEntity(
                patient.id(),
                patient.lastName(),
                patient.firstName(),
                AddressEntity.from( patient.address() ),
                patient.dni(),
                patient.createdDate()
        );
    }
}
