package com.ilionx.foodapp.services;

import com.ilionx.foodapp.models.Dish;
import com.ilionx.foodapp.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        return dishRepository.findByName(name);
    }

    public Optional<List<Dish>> findBelowPrice (Double price){return dishRepository.findDishUnderPrice(price);}

    public Optional<List<Dish>> findAbovePrice (Double price){return dishRepository.findDishAbovePrice(price);}

    @Transactional
    public Optional<Dish> updateDish(Dish dish, long id){
        Optional<Dish> optionalDish = findById(id);
        if(optionalDish.isPresent()){
            Dish oldDish = optionalDish.get();
            oldDish.setGroupName((dish.getGroupName()));
            oldDish.setName(dish.getName());
            oldDish.setDescription(dish.getDescription());
            oldDish.setPrice(dish.getPrice());
            save(oldDish);
        }
        return optionalDish;
    }
}
