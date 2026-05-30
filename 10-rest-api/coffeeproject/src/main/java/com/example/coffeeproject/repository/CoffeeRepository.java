package com.example.coffeeproject.repository;

import com.example.coffeeproject.entity.Coffee;

import java.util.List;

public class CoffeeRepository {
    public List<Coffee> findAll() {
        return List.of();
    }

    public void findById(Long id) {
    }

    public Coffee save(Coffee coffee) {
        return coffee;
    }
}
