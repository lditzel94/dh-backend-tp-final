package com.digitalhouse.tpfinal.dentist.service;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import com.digitalhouse.tpfinal.dentist.model.error.DentistNotFoundException;

import java.util.Optional;

public interface DentistService {
    Dentist create( Dentist dentist );

    Dentist findBy( Long license ) throws DentistNotFoundException;

    Optional<Dentist> modify( Dentist oldDentist, Dentist newDentist );

    Optional<Long> delete( Long license );
}
