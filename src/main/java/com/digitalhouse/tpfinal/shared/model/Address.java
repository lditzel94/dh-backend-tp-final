package com.digitalhouse.tpfinal.shared.model;

import lombok.Builder;

@Builder
public record Address(
        String street,
        Integer number
) {
}
