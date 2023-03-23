package com.digitalhouse.tpfinal.dentist.service;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;

import java.util.List;
import java.util.Optional;

public interface DentistService {
    List<Dentist> findAll();

    Optional<Dentist> findBy( Long id );

    Optional<Dentist> create( Dentist dentist );

    Optional<Dentist> update( Dentist dentist );

    void deleteBy( Long license );
}
