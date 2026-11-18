package org.formation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.formation.dto.CoffeeCreateDto;
import org.formation.dto.CoffeeDto;
import org.formation.entity.Coffee;
import org.formation.repository.CoffeeRepository;
import org.formation.service.CoffeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("coffees")
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;
    @PostMapping
    CoffeeDto create(@RequestBody @Valid CoffeeCreateDto dto)
    {
        return coffeeService.create(dto);
    }

    @GetMapping
    List<CoffeeDto> coffees()
    {
        //CoffeeDto bob = new CoffeeDto(2L, "bob", 88);


        return coffeeService.allCoffees();
    }

    @GetMapping("{id}")
    ResponseEntity<CoffeeDto> coffee(@PathVariable Long id){
        return coffeeService.oneCoffee(id).map( ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    //List<CoffeeDto> allCoffees();
}
