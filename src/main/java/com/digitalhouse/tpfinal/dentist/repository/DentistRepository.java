package com.digitalhouse.tpfinal.dentist.repository;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import com.digitalhouse.tpfinal.dentist.model.entity.DentistEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class DentistRepository {
    private final DentistJpaRepository repository;

    public Optional<Dentist> save( Dentist dentist ) {
        return Optional.ofNullable( doSave( dentist ) )
                       .map( DentistEntity::toDomain );
    }

    public Optional<Dentist> findBy( Long id ) {
        return repository.findById( id )
                         .map( DentistEntity::toDomain );
    }

    public List<Dentist> findAll() {
        return repository.findAll()
                         .stream()
                         .map( DentistEntity::toDomain )
                         .toList();
    }

    public void deleteBy( Long id ) {
        repository.deleteById( id );
    }

    private DentistEntity doSave( Dentist dentist ) {
        return repository.save( DentistEntity.from( dentist ) );
    }
}
