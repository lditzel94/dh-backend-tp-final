package com.digitalhouse.tpfinal.patient.service;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import com.digitalhouse.tpfinal.patient.model.domain.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    Optional<Patient> create( Patient patient );

    Optional<Patient> findBy( Long id );

    List<Patient> findAll();

    void deleteBy( Long id );
}
