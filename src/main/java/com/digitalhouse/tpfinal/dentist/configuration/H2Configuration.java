import com.digitalhouse.tpfinal.dentist.model.entity.DentistEntity;
import com.digitalhouse.tpfinal.dentist.repository.DentistJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class H2Configuration {
    private final DentistJpaRepository repository;


    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            repository.save(
                    DentistEntity.builder()
                                 .license( 33333L )
                                 .firstName( "Luciano" )
                                 .lastName( "Ditzel" )
                                 .build()
            );
        };
    }
}
