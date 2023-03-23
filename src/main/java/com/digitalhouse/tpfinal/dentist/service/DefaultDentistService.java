package com.digitalhouse.tpfinal.dentist.service;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import com.digitalhouse.tpfinal.dentist.repository.DentistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class DefaultDentistService implements DentistService {
    private final DentistRepository repository;


    @Override
    public Optional<Dentist> findBy( Long id ) {
        return repository.findBy( id );
    }

    @Override
    public List<Dentist> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Dentist> create( Dentist dentist ) {
        return repository.save( dentist );
    }

    @Override
    @Transactional
    public Optional<Dentist> update( Dentist withUpdates ) throws NullPointerException {
        return repository.findBy( withUpdates.id() )
                         .flatMap( doUpdate( withUpdates ) );
    }

    @Override
    @Transactional
    public void deleteBy( Long license ) {
        repository.deleteBy( license );
    }

    private Function<Dentist, Optional<Dentist>> doUpdate( Dentist withUpdates ) {
        return dentist -> repository.save( dentist.copy( withUpdates ) );
    }
}
