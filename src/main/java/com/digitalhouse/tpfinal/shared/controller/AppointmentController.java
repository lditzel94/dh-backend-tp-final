package com.digitalhouse.tpfinal.shared.controller;

import com.digitalhouse.tpfinal.dentist.model.error.DentistNotFoundException;
import com.digitalhouse.tpfinal.dentist.service.DentistService;
import com.digitalhouse.tpfinal.patient.model.error.PatientNotFoundException;
import com.digitalhouse.tpfinal.patient.service.PatientService;
import com.digitalhouse.tpfinal.shared.model.dto.AppointmentRequest;
import com.digitalhouse.tpfinal.shared.model.dto.AppointmentResponse;
import com.digitalhouse.tpfinal.shared.model.error.ServerError;
import com.digitalhouse.tpfinal.shared.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RequestMapping( "/api/appointments" )
@RestController
@CrossOrigin
class AppointmentController {
    private final AppointmentService appointmentService;
    private final DentistService dentistService;
    private final PatientService patientService;

    @GetMapping
    List<AppointmentResponse> findAll() {
        return appointmentService.findAll()
                                 .stream()
                                 .map( AppointmentResponse::from )
                                 .toList();
    }

    @PostMapping
    @ResponseStatus( CREATED )
    AppointmentResponse create(
            @Valid
            @RequestBody
            AppointmentRequest appointmentRequest
    ) throws RuntimeException {
        var dentist = dentistService.findBy( appointmentRequest.dentistId() ).orElseThrow( DentistNotFoundException::new );
        var patient = patientService.findBy( appointmentRequest.patientId() ).orElseThrow( PatientNotFoundException::new );
        var appointment = appointmentRequest.toDomain( dentist, patient );

        return appointmentService.create( appointment )
                                 .map( AppointmentResponse::from )
                                 .orElseThrow( ServerError::new );
    }
}
