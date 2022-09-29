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

    // Normal SQL query syntax
    @Query(value = "select * from dish where price > ?1 and price < ?2", nativeQuery = true)
    Optional<List<Dish>> findDishBetweenPrice(Double startPrice, Double endPrice);

    // JPQL query syntax: JPQL works with every database
    @Query("select d from Dish d where d.groupName like %?1%")
    Optional<List<Dish>> findDishByGroup(String groupName);
}
