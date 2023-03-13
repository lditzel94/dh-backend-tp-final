package com.digitalhouse.tpfinal.dentist.repository;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class DentistRepository {
    private final DentistJpaRepository repository;

    public Optional<Dentist> save( Dentist dentist ) {
        return Optional.empty();
    }

    public Optional<Dentist> findBy( Long license ) {
        return Optional.empty();
    }

    public Optional<Long> deleteBy( Long license ) {
        return Optional.empty();
    }
}
