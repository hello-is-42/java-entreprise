package org.formation.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.formation.dto.CoffeeCreateDto;
import org.formation.entity.Coffee;
import org.formation.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.formation.mapper.CoffeeMapper;
import org.formation.dto.CoffeeDto;
import org.formation.entity.Coffee;
import org.formation.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository repository;
    private final CoffeeMapper mapper;

    @PostConstruct
    void initDb()
    {
        repository.saveAll(List.of(new Coffee("espresso", 30), new Coffee("double espresso", 40), new Coffee("latte", 70), new Coffee("cappuccino", 80)));
    }

    /*public CoffeeServiceImpl(CoffeeRepository repository)
    {
        this.repository = repository;
    }*/

    @Override
    public List<CoffeeDto> allCoffees() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<CoffeeDto> oneCoffee(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public CoffeeDto create(CoffeeCreateDto coffeeDto) {
        Coffee entity = mapper.toEntity(coffeeDto);
        Coffee saved = repository.save(entity);
        return mapper.toDto(saved);
    }

}
