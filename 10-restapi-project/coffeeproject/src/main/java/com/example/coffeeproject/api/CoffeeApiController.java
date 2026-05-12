package com.example.coffeeproject.api;

import com.example.coffeeproject.dto.CoffeeDTO;
import com.example.coffeeproject.entity.Coffee;
import com.example.coffeeproject.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class CoffeeApiController {

    private final CoffeeRepository coffeeRepository;

    // read all
    @GetMapping
    public List<Coffee> getCoffees() {
        return coffeeRepository.findAll();
    }

    // read one article
    @GetMapping("/{id}")
    public Coffee getCoffee(@PathVariable Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    // insert
    @PostMapping
    public Coffee createCoffee(@RequestBody CoffeeDTO coffeeForm) {
        log.info("Creating article: {}", coffeeForm);
        Coffee coffee = coffeeForm.toEntity();
        log.info("Saving article: {}", coffee);
        return coffeeRepository.save(coffee);
    }

}
