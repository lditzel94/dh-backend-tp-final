package com.digitalhouse.tpfinal.shared.service;

import com.digitalhouse.tpfinal.shared.model.domain.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Optional<Appointment> create( Appointment appointment );

    List<Appointment> findAll();
}
