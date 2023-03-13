package com.digitalhouse.tpfinal.dentist.service;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import com.digitalhouse.tpfinal.dentist.repository.DentistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DefaultDentistService implements DentistService {
    private final DentistRepository repository;

    @Override
    public Optional<Dentist> create( Dentist dentist ) {
        return repository.save( dentist );
    }

    @Override
    public Optional<Dentist> findBy( Long license ) {
        return repository.findBy( license );
    }

    @Override
    public List<Dentist> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Dentist> modify( Dentist oldDentist, Dentist newDentist ) {
        return repository.save( newDentist );
    }

    @Override
    public void deleteBy( Long license ) {
        repository.deleteBy( license );
    }
}
