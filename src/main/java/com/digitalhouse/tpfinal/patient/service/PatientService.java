package com.digitalhouse.tpfinal.patient.service;

import com.digitalhouse.tpfinal.patient.model.domain.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> findAll();

    Optional<Patient> findBy( Long id );

    Optional<Patient> create( Patient patient );

    Optional<Patient> update( Patient patient );

    void deleteBy( Long id );
}
