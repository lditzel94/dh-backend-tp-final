package com.digitalhouse.tpfinal.patient.repository;

import com.digitalhouse.tpfinal.patient.model.domain.Patient;
import com.digitalhouse.tpfinal.patient.model.entity.PatientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PatientRepository {
    private final PatientJpaRepository repository;

    public Optional<Patient> save( Patient patient ) {
        return Optional.empty();
    }

    public Optional<Patient> findBy( Long id ) {
        return Optional.empty();
    }

    public List<Patient> findAll() {
        return repository.findAll()
                         .stream()
                         .map( PatientEntity::toDomain )
                         .toList();
    }

    public void deleteBy( Long id ) {
        repository.deleteById( id );
    }
}
