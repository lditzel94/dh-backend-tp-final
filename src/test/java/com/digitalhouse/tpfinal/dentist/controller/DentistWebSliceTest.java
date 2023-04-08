package com.digitalhouse.tpfinal.dentist.controller;

import com.digitalhouse.tpfinal.BackendTpFinalApplication;
import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import com.digitalhouse.tpfinal.dentist.model.dto.DentistDTO;
import com.digitalhouse.tpfinal.dentist.service.DentistService;
import com.digitalhouse.tpfinal.shared.configuration.SecurityConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RequiredArgsConstructor
@ContextConfiguration( classes = { BackendTpFinalApplication.class, SecurityConfiguration.class })
@WebMvcTest( controllers = { DentistController.class } )
class DentistWebSliceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DentistService dentistService;

    @Test
    void testFindAll() throws Exception {
        List<Dentist> dentists = Arrays.asList(
                Dentist.builder()
                       .id( 1L )
                       .firstName( "John" )
                       .lastName( "Doe" )
                       .build(),
                Dentist.builder()
                       .id( 2L )
                       .firstName( "Jane" )
                       .lastName( "Doe" )
                       .build()
        );

        given( dentistService.findAll() ).willReturn( dentists );

        mockMvc.perform( get( "/api/dentists" )
                                 .with( user( "admin" ).password( "password" ).roles( "ADMIN" ) ) )
               .andExpect( status().isOk() )
               .andExpect( jsonPath( "$", hasSize( 2 ) ) )
               .andExpect( jsonPath( "$[0].id", is( 1 ) ) )
               .andExpect( jsonPath( "$[0].firstName", is( "John" ) ) )
               .andExpect( jsonPath( "$[0].lastName", is( "Doe" ) ) )
               .andExpect( jsonPath( "$[1].id", is( 2 ) ) )
               .andExpect( jsonPath( "$[1].firstName", is( "Jane" ) ) )
               .andExpect( jsonPath( "$[1].lastName", is( "Doe" ) ) );
    }

    @Test
    void testFindBy() throws Exception {
        given( dentistService.findBy( 1L ) ).willReturn( Optional.of( new Dentist( 1L, 123L, "Doe", "John" ) ) );

        mockMvc.perform( get( "/api/dentists/1" )
                                 .with( user( "admin" ).password( "password" ).roles( "ADMIN" ) ) )
               .andExpect( status().isOk() )
               .andExpect( jsonPath( "$.id", is( 1 ) ) )
               .andExpect( jsonPath( "$.firstName", is( "John" ) ) )
               .andExpect( jsonPath( "$.lastName", is( "Doe" ) ) );
    }

    @Test
    @WithMockUser
    @Disabled
    void testCreate() throws Exception {
        DentistDTO.Request.Create request = new DentistDTO.Request.Create( 123L, "Doe", "John" );
        Dentist dentist = new Dentist( 1L, 123L, "Doe", "John" );

        given( dentistService.create( request.toDomain() ) ).willReturn( Optional.of( dentist ) );

        mockMvc.perform( post( "/api/dentists" )
                                 .with( user( "admin" ).password( "password" ).roles( "ADMIN" ) )
                                 .contentType( MediaType.APPLICATION_JSON )
                                 .content( new ObjectMapper().writeValueAsString( request ) ) )
               .andExpect( status().isCreated() )
               .andExpect( jsonPath( "$.id", is( 1 ) ) )
               .andExpect( jsonPath( "$.firstName", is( "John" ) ) )
               .andExpect( jsonPath( "$.lastName", is( "Doe" ) ) );
    }

    @Test
    @Disabled
    void testUpdate() throws Exception {
        DentistDTO.Request.Update request = new DentistDTO.Request.Update( 1L, 123L, "Doe", "John" );
        Dentist dentist = new Dentist( 1L, 123L, "Does", "John" );

        given( dentistService.update( request.toDomain() ) ).willReturn( Optional.of( dentist ) );

        mockMvc.perform( patch( "/api/dentists" )
                                 .contentType( MediaType.APPLICATION_JSON )
                                 .content( new ObjectMapper().writeValueAsString( request ) ) )
               .andExpect( status().isOk() )
               .andExpect( jsonPath( "$.id", is( 1 ) ) )
               .andExpect( jsonPath( "$.firstName", is( "John" ) ) )
               .andExpect( jsonPath( "$.lastName", is( "Doe" ) ) );
    }

    @Test
    @Disabled
    void testDelete() throws Exception {
        mockMvc.perform( delete( "/api/dentists/1" ) )
               .andExpect( status().isNoContent() );

        verify( dentistService ).deleteBy( 1L );
    }

}