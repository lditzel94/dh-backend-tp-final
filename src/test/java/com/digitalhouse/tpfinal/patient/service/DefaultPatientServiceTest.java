package com.digitalhouse.tpfinal.patient.service;

import com.digitalhouse.tpfinal.patient.model.domain.Patient;
import com.digitalhouse.tpfinal.patient.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class )
class DefaultPatientServiceTest {

    @Mock
    PatientRepository repositoryMock;

    @InjectMocks
    DefaultPatientService service;

    @Test
    void findAll_shouldCallRepositoryFindAll() {
        List<Patient> expected = new ArrayList<>();
        when( repositoryMock.findAll() ).thenReturn( expected );
        List<Patient> actual = service.findAll();
        verify( repositoryMock, times( 1 ) ).findAll();
        assertEquals( expected, actual );
    }

    @Test
    void findBy_shouldCallRepositoryFindBy() {
        Long id = 1L;
        when( repositoryMock.findBy( id ) ).thenReturn( Optional.empty() );
        service.findBy( id );
        verify( repositoryMock, times( 1 ) ).findBy( id );
    }

    @Test
    void create_shouldCallRepositorySave() {
        Patient patient = Patient.builder().build();
        when( repositoryMock.save( patient ) ).thenReturn( Optional.of( patient ) );
        Optional<Patient> result = service.create( patient );
        verify( repositoryMock, times( 1 ) ).save( patient );
        assertEquals( Optional.of( patient ), result );
    }

    @Test
    void update_shouldCallRepositoryFindByAndSave() {
        Patient patient = Patient.builder()
                                 .id( 1L )
                                 .lastName( "Ditzell" )
                                 .build();
        Patient updatedPatient = Patient.builder()
                                        .id( 1L )
                                        .lastName( "Ditzel" )
                                        .build();
        ;
        when( repositoryMock.findBy( 1L ) ).thenReturn( Optional.of( patient ) );
        when( repositoryMock.save( updatedPatient ) ).thenReturn( Optional.of( updatedPatient ) );
        Optional<Patient> result = service.update( updatedPatient );
        verify( repositoryMock, times( 1 ) ).findBy( 1L );
        verify( repositoryMock, times( 1 ) ).save( patient.copy( updatedPatient ) );
        assertEquals( Optional.of( updatedPatient ), result );
    }

    @Test
    void deleteBy_shouldCallRepositoryDeleteBy() {
        Long id = 123L;
        doNothing().when( repositoryMock ).deleteBy( id );
        service.deleteBy( id );
        verify( repositoryMock, times( 1 ) ).deleteBy( id );
    }
}