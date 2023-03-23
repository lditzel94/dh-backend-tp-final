package com.digitalhouse.tpfinal.patient.service;

import com.digitalhouse.tpfinal.patient.model.domain.Patient;
import com.digitalhouse.tpfinal.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class DefaultPatientService implements PatientService {
    private final PatientRepository repository;

    @Override
    public List<Patient> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Patient> findBy( Long id ) {
        return repository.findBy( id );
    }

    public Optional<Patient> create( Patient patient ) {
        return repository.save( patient );
    }

    @Override
    @Transactional
    public Optional<Patient> update( Patient withUpdates ) {
        return repository.findBy( withUpdates.id() )
                         .flatMap( doUpdate( withUpdates ) );
    }

    @Override
    @Transactional
    public void deleteBy( Long id ) {
        repository.deleteBy( id );
    }

    private Function<Patient, Optional<Patient>> doUpdate( Patient withUpdates ) {
        return patient -> repository.save( patient.copy( withUpdates ) );
    }
}
