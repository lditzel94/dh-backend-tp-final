package com.digitalhouse.tpfinal.shared.model.entity;

import com.digitalhouse.tpfinal.dentist.model.entity.DentistEntity;
import com.digitalhouse.tpfinal.patient.model.entity.PatientEntity;
import com.digitalhouse.tpfinal.shared.model.domain.Appointment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table( name = "APPOINTMENT" )
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn( name = "patient_id", nullable = false )
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn( name = "dentist_id", nullable = false )
    private DentistEntity dentist;

    private LocalDateTime dateTime;

    public Appointment toDomain() {
        return Appointment.builder()
                          .id( id )
                          .patient( patient.toDomain() )
                          .dentist( dentist.toDomain() )
                          .dateTime( dateTime )
                          .build();
    }

    public static AppointmentEntity from( Appointment appointment ) {
        return new AppointmentEntity(
                appointment.id(),
                PatientEntity.from( appointment.patient() ),
                DentistEntity.from( appointment.dentist() ),
                appointment.dateTime()
        );
    }
}
