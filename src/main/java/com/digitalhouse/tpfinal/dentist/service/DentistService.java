package com.digitalhouse.tpfinal.dentist.service;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;

import java.util.List;
import java.util.Optional;

public interface DentistService {
    Optional<Dentist> create( Dentist dentist );

    Optional<Dentist> findBy( Long id );

    List<Dentist> findAll();

    Optional<Dentist> modify( Dentist oldDentist, Dentist newDentist );

    void deleteBy( Long license );
}
