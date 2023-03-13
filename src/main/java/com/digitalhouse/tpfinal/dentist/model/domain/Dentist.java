package com.digitalhouse.tpfinal.dentist.model.domain;

import lombok.Builder;

@Builder
public record Dentist(
        Long license,
        String lastName,
        String firstName
) {
}
