package com.digitalhouse.tpfinal.patient.model.domain;

import com.digitalhouse.tpfinal.shared.model.domain.Address;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record Patient(
        Long id,
        String lastName,
        String firstName,
        Address address,
        String dni,
        LocalDate createdDate
) {
}
