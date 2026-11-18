package org.formation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Coffee {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "coffee name cannot be null")
    private String name;
    @Positive(message = "price cannot be negative")
    private int price;

    public Coffee(String name, int price)
    {
        this.name = name;
        this.price = price;
    }
}
