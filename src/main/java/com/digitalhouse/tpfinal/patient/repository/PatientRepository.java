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
        return Optional.ofNullable( doSave( patient ) )
                       .map( PatientEntity::toDomain );
    }

    public Optional<Patient> findBy( Long id ) {
        return repository.findById( id )
                         .map( PatientEntity::toDomain );
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

    private PatientEntity doSave( Patient patient ) {
        return repository.save( PatientEntity.from( patient ) );
    }
}
