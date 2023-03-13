package com.digitalhouse.tpfinal.patient.repository;

import com.digitalhouse.tpfinal.patient.model.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientJpaRepository extends JpaRepository<PatientEntity, Long> {
}
