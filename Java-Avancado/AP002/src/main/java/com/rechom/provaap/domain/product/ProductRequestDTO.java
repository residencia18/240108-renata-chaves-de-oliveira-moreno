package com.rechom.provaap.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record ProductRequestDTO(
        @NotBlank
        String name,

        @NotNull
        Integer price
) {
}
