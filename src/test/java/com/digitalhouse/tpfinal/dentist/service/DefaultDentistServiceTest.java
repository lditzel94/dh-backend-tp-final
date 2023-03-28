package com.digitalhouse.tpfinal.dentist.service;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import com.digitalhouse.tpfinal.dentist.repository.DentistRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class )
class DefaultDentistServiceTest {

    @Mock
    DentistRepository repository;

    @InjectMocks
    DefaultDentistService service;

    @Nested
    @DisplayName( "Find all dentist" )
    class FindAll {
        @Test
        @DisplayName( "Records found" )
        void found() {
            when( repository.findAll() ).thenReturn( List.of(
                    Dentist.builder().build()
            ) );

            assertThat( service.findAll() ).isNotEmpty();
        }

        @Test
        @DisplayName( "No records found" )
        void notFound() {
            when( repository.findAll() ).thenReturn( Collections.emptyList() );

            assertThat( service.findAll() ).isEmpty();
        }
    }

    @Nested
    @DisplayName( "Find by id" )
    @Disabled
    class FindById {
        @Test
        @DisplayName( "Record found" )
        void found() {
            var id = 1L;
            var aDentist = Optional.of( Dentist.builder().build() );

            doReturn( aDentist ).when( repository ).findBy( id );

            assertThat( service.findBy( id ) ).isEqualTo( aDentist );
            verify( repository, atMostOnce() ).findBy( id );
        }

        @Test
        @DisplayName( "Not found" )
        void notFound() {
            var id = 1L;
            doReturn( empty() ).when( repository ).findBy( id );

            assertThat( service.findBy( id ) ).isNotPresent();
            verify( repository, atMostOnce() ).findBy( id );
        }

    }

    @Nested
    @DisplayName( "Create dentist" )
    class CreateDentist {
        @Test
        @DisplayName( "Successfully created" )
        void created() {

        }

    }

}