package org.formation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CoffeeCreateDto(@NotBlank(message = "coffee name cannot be null")
                              String name,
                              @Positive(message = "price cannot be negative")
                              int price) {
}
