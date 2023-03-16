package com.digitalhouse.tpfinal.dentist.repository;

import com.digitalhouse.tpfinal.dentist.model.entity.DentistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistJpaRepository extends JpaRepository<DentistEntity, Long> {
}
