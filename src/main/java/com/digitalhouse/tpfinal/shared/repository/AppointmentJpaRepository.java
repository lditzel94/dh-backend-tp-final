package com.digitalhouse.tpfinal.shared.repository;

import com.digitalhouse.tpfinal.shared.model.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentJpaRepository extends JpaRepository<AppointmentEntity, Long> {
}
