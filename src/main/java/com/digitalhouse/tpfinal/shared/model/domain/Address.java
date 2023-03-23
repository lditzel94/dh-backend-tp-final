package com.digitalhouse.tpfinal.shared.model.domain;

import lombok.Builder;

@Builder
public record Address(
        String street,
        Integer number
) {
}
