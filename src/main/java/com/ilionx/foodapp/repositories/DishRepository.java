package com.ilionx.foodapp.repositories;

import com.ilionx.foodapp.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    // Makes possible to find a dish by name
    Optional<Dish> findByName(String name);

    // JPQL query syntax
    @Query("select d from Dish d where d.price < ?1")
    Optional<List<Dish>> findDishUnderPrice(Double price);

    // Normal SQL query syntax
    @Query(value = "select * from dish where price > ?1", nativeQuery = true)
    Optional<List<Dish>> findDishAbovePrice(Double price);
}
