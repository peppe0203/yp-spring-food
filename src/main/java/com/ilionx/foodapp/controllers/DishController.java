package com.ilionx.foodapp.controllers;


import com.ilionx.foodapp.models.Dish;
import com.ilionx.foodapp.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public ResponseEntity<List<Dish>> getAllDishes() {
        return ResponseEntity.ok(this.dishService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable long id) {
        Optional<Dish> optionalDish = this.dishService.findById(id);
        if (optionalDish.isPresent()){
            return ResponseEntity.ok(optionalDish.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/name:{name}")
    public ResponseEntity<Dish> getDishByName(@PathVariable String name) {
        Optional<Dish> optionalDish = this.dishService.findByName(name);
        if (optionalDish.isPresent()){
            return ResponseEntity.ok(optionalDish.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/priceBelow:{price}")
    public ResponseEntity<Optional<List<Dish>>> getDishBelowPrice(@PathVariable Double price){
        if (!this.dishService.findBelowPrice(price).get().isEmpty()){
            return ResponseEntity.ok(this.dishService.findBelowPrice(price));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/priceAbove:{price}")
    public ResponseEntity<Optional<List<Dish>>> getDishAbovePrice(@PathVariable Double price){
        if (!this.dishService.findAbovePrice(price).get().isEmpty()){
            return ResponseEntity.ok(this.dishService.findAbovePrice(price));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) throws URISyntaxException {
        Dish newDish =this.dishService.save(dish);
        return ResponseEntity.created(new URI("" + newDish.getId())).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Dish> updateDish(@RequestBody Dish dish, @PathVariable long id) {
        Optional<Dish> optionalDish = this.dishService.updateDish(dish, id);
        if(optionalDish.isPresent()){
            return ResponseEntity.ok(optionalDish.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Dish> deleteDishById(@PathVariable long id) {
        if (this.dishService.findById(id).isPresent()){
            this.dishService.deleteById(id);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    //TODO return responscodes
    //TODO avoid backend logic in the controller move this to the service
}
