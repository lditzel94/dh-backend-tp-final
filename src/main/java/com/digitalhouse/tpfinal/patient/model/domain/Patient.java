package com.digitalhouse.tpfinal.patient.model.domain;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record Patient(
        Long id,
        String lastName,
        String firstName,
        String address, //TODO: refactor to Address object
        String dni,
        LocalDate createdDate
) {
}
