package com.digitalhouse.tpfinal.shared.configuration;

import com.digitalhouse.tpfinal.dentist.model.entity.DentistEntity;
import com.digitalhouse.tpfinal.dentist.repository.DentistJpaRepository;
import com.digitalhouse.tpfinal.patient.model.entity.PatientEntity;
import com.digitalhouse.tpfinal.patient.repository.PatientJpaRepository;
import com.digitalhouse.tpfinal.shared.model.entity.AddressEntity;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    public ApplicationRunner applicationRunner( DentistJpaRepository dentistRepository, PatientJpaRepository patientRepository ) {
        return args -> {
            dentistRepository.save(
                    new DentistEntity(
                            null,
                            1L,
                            "Ditzel",
                            "Luciano"
                    )
            );

            patientRepository.save(
                    new PatientEntity(
                            null,
                            "Ditzel",
                            "Agustin",
                            new AddressEntity( null, "Cabildo", 3000 ),
                            "1234",
                            LocalDate.now()
                    )
            );
        };
    }
}
