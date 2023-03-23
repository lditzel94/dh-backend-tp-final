package com.digitalhouse.tpfinal.shared.repository;

import com.digitalhouse.tpfinal.shared.model.domain.Appointment;
import com.digitalhouse.tpfinal.shared.model.entity.AppointmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class AppointmentRepository {
    private final AppointmentJpaRepository repository;

    public Optional<Appointment> save( Appointment appointment ) {
        return Optional.of( doSave( appointment ) )
                       .map( AppointmentEntity::toDomain );
    }

    public List<Appointment> findAll() {
        return repository.findAll()
                         .stream()
                         .map( AppointmentEntity::toDomain )
                         .toList();
    }

    private AppointmentEntity doSave( Appointment appointment ) {
        return repository.save( AppointmentEntity.from( appointment ) );
    }
}
