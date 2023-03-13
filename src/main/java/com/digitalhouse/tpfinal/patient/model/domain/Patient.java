package com.digitalhouse.tpfinal.patient.model.domain;

import lombok.Builder;

@Builder
public record Patient(
        Long id,
        String lastName,
        String firstName,
        String address, //TODO: refactor to Address object
        String dni,
        String createdDate //TODO: refactor to some timestamp type
) {
}
