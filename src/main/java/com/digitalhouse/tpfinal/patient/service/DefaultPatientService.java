package com.digitalhouse.tpfinal.patient.service;

import com.digitalhouse.tpfinal.patient.model.domain.Patient;
import com.digitalhouse.tpfinal.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DefaultPatientService implements PatientService {
    private final PatientRepository repository;

    public Optional<Patient> create( Patient patient ) {
        return repository.save( patient );
    }

    @Override
    public Optional<Patient> findBy( Long id ) {
        return repository.findBy( id );
    }

    @Override
    public List<Patient> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteBy( Long id ) {
        repository.deleteBy( id );
    }
}
