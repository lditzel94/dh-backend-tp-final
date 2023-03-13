package com.digitalhouse.tpfinal.dentist.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table( name = "DENTIST" )
@Builder
public class DentistEntity {
    @Id
    @GeneratedValue( strategy = IDENTITY )
    private Long id;
    Long license;
    String lastName;
    String firstName;
}
