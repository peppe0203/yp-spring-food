package com.ilionx.foodapp.services;

import com.ilionx.foodapp.models.Dish;
import com.ilionx.foodapp.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Transactional
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    public Optional<Dish> findById(Long id) {
        return dishRepository.findById(id);
    }

    public void deleteById(Long id) {
        dishRepository.deleteById(id);
    }

    public Optional<Dish> findByName(String name){
        return this.dishRepository.findByName(name);
    }

    @Transactional
    public Optional<Dish> updateDish(Dish dish, long id){
        Optional<Dish> optionalDish = findById(id);
        if(optionalDish.isPresent()){
            Dish oldDish = optionalDish.get();
            oldDish.setName(dish.getName());
            oldDish.setDescription(dish.getDescription());
            oldDish.setPrice(dish.getPrice());
            save(oldDish);
        }
        return optionalDish;
    }
}
