package com.digitalhouse.tpfinal.shared.service;

import com.digitalhouse.tpfinal.shared.model.domain.Appointment;
import com.digitalhouse.tpfinal.shared.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DefaultAppointmentService implements AppointmentService {
    private final AppointmentRepository repository;


    @Override
    public Optional<Appointment> create( Appointment appointment ) {
        return repository.save( appointment );
    }

    @Override
    public List<Appointment> findAll() {
        return repository.findAll();
    }
}
