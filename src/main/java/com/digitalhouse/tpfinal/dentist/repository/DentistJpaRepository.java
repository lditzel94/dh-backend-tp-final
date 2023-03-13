package com.digitalhouse.tpfinal.dentist.repository;

import com.digitalhouse.tpfinal.dentist.model.entity.DentistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DentistJpaRepository extends JpaRepository<DentistEntity, Long> {
    Optional<DentistEntity> findByLicense( Long license );

    void deleteByLicense( Long license );
}
