package com.digitalhouse.tpfinal.dentist.service;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import com.digitalhouse.tpfinal.dentist.model.error.DentistNotFoundException;
import com.digitalhouse.tpfinal.dentist.repository.DentistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DefaultDentistService implements DentistService {
    private final DentistRepository repository;

    @Override
    public Dentist create( Dentist dentist ) {
        return repository.save( dentist )
                         .orElse( dentist );
    }

    @Override
    public Dentist findBy( Long license ) throws DentistNotFoundException {
        return repository.findBy( license )
                         .orElseThrow( DentistNotFoundException::new );
    }

    @Override
    public Optional<Dentist> modify( Dentist oldDentist, Dentist newDentist ) {
        return repository.save( newDentist );
    }

    @Override
    public Optional<Long> delete( Long license ) {
        return repository.deleteBy( license );
    }
}
