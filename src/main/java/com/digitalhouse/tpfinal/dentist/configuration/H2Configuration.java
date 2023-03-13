package com.digitalhouse.tpfinal.dentist.configuration;

import com.digitalhouse.tpfinal.dentist.model.entity.DentistEntity;
import com.digitalhouse.tpfinal.dentist.repository.DentistJpaRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2Configuration {

    @Bean
    public ApplicationRunner applicationRunner( DentistJpaRepository repository ) {
        return args -> {
            repository.save(
                    new DentistEntity(
                            null,
                            33333L,
                            "Ditzel",
                            "Luciano"
                    )
            );
        };
    }
}
