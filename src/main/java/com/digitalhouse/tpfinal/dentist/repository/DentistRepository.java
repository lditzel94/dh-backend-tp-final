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
        return Optional.empty();
    }

    public Optional<Dentist> findBy( Long license ) {
        return repository.findByLicense( license )
                         .map( DentistEntity::toDomain );
    }

    public List<Dentist> findAll() {
        return repository.findAll()
                         .stream()
                         .map( DentistEntity::toDomain )
                         .toList();
    }

    public void deleteBy( Long license ) {
        repository.deleteByLicense( license );
    }
}
