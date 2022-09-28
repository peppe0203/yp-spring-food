package com.ilionx.foodapp.repositories;

import com.ilionx.foodapp.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    // Makes possible to find a dish by name
    Optional<Dish> findByName(String name);
}
