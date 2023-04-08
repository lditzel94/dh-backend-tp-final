package com.digitalhouse.tpfinal.dentist.service;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import com.digitalhouse.tpfinal.dentist.repository.DentistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class )
class DefaultDentistServiceTest {

    @Mock
    DentistRepository repository;

    @InjectMocks
    DefaultDentistService service;

    @Test
    void findBy_shouldCallRepositoryFindBy() {
        Long id = 1L;
        when( repository.findBy( id ) ).thenReturn( Optional.empty() );
        service.findBy( id );
        verify( repository, times( 1 ) ).findBy( id );
    }

    @Test
    void findAll_shouldCallRepositoryFindAll() {
        List<Dentist> expected = new ArrayList<>();
        when( repository.findAll() ).thenReturn( expected );
        List<Dentist> actual = service.findAll();
        verify( repository, times( 1 ) ).findAll();
        assertEquals( expected, actual );
    }

    @Test
    void create_shouldCallRepositorySave() {
        Dentist dentist = Dentist.builder().build();
        when( repository.save( dentist ) ).thenReturn( Optional.of( dentist ) );
        Optional<Dentist> result = service.create( dentist );
        verify( repository, times( 1 ) ).save( dentist );
        assertEquals( Optional.of( dentist ), result );
    }

    @Test
    void update_shouldCallRepositoryFindByAndSave() {
        Dentist dentist = Dentist.builder()
                                 .id( 1L )
                                 .license( 123L )
                                 .build();
        Dentist updatedDentist = Dentist.builder()
                                        .id( 1L )
                                        .license( 123L )
                                        .build();
        when( repository.findBy( 1L ) ).thenReturn( Optional.of( dentist ) );
        when( repository.save( updatedDentist ) ).thenReturn( Optional.of( updatedDentist ) );
        Optional<Dentist> result = service.update( updatedDentist );
        verify( repository, times( 1 ) ).findBy( 1L );
        verify( repository, times( 1 ) ).save( dentist.copy( updatedDentist ) );
        assertEquals( Optional.of( updatedDentist ), result );
    }

    @Test
    void deleteBy_shouldCallRepositoryDeleteBy() {
        Long license = 123L;
        doNothing().when( repository ).deleteBy( license );
        service.deleteBy( license );
        verify( repository, times( 1 ) ).deleteBy( license );
    }

    //@Nested
    //@DisplayName( "Find all dentist" )
    //class FindAll {
    //    @Test
    //    @DisplayName( "Records found" )
    //    void found() {
    //        when( repository.findAll() ).thenReturn( List.of(
    //                Dentist.builder().build()
    //        ) );
    //
    //        assertThat( service.findAll() ).isNotEmpty();
    //        verify( repository, atMostOnce() ).findAll();
    //    }
    //
    //    @Test
    //    @DisplayName( "No records found" )
    //    void notFound() {
    //        when( repository.findAll() ).thenReturn( Collections.emptyList() );
    //
    //        assertThat( service.findAll() ).isEmpty();
    //        verify( repository, atMostOnce() ).findAll();
    //    }
    //}
    //
    //@Nested
    //@DisplayName( "Find by id" )
    //class FindById {
    //    @Test
    //    @DisplayName( "Record found" )
    //    void found() {
    //        var id = 1L;
    //        var aDentist = Optional.of( Dentist.builder().build() );
    //
    //        when( repository.findBy( id ) ).thenReturn( aDentist );
    //
    //        assertThat( service.findBy( id ) ).isEqualTo( aDentist );
    //        verify( repository, atMostOnce() ).findBy( id );
    //    }
    //
    //    @Test
    //    @DisplayName( "Not found" )
    //    void notFound() {
    //        var id = 1L;
    //        doReturn( empty() ).when( repository ).findBy( id );
    //
    //        assertThat( service.findBy( id ) ).isNotPresent();
    //        verify( repository, atMostOnce() ).findBy( id );
    //    }
    //
    //}
    //
    //@Nested
    //@DisplayName( "Create dentist" )
    //class CreateDentist {
    //    @Test
    //    @DisplayName( "Successfully created" )
    //    void created() {
    //
    //    }
    //
    //}

}