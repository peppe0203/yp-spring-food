package com.ilionx.foodapp.services;

import com.ilionx.foodapp.models.Dish;
import com.ilionx.foodapp.models.Cook;
import com.ilionx.foodapp.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    // Autowired beans from beansConfig
    @Autowired
    private Cook chefCook;
    @Autowired
    private Cook assistantCook;
    @Value("${companyName}")
    private String companyName;

    @Autowired
    private DishRepository dishRepository;

    // The next function is for test purposes for beans and configuration values
    // This function is called when doing a get request for searching all dishes
    public void testBeanAndConfig(){
        System.out.println("Chef cook: " + chefCook.getName());
        System.out.println("Assistant cook: " + assistantCook.getName());
        System.out.println("Working for company: " + companyName);
    }

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

    public Optional<Dish> findByName(String name) {
        return dishRepository.findByName(name);
    }

    public Optional<List<Dish>> findBetweenPrice(Double startPrice, Double endPrice) {
        return dishRepository.findDishBetweenPrice(startPrice, endPrice);
    }

    public Optional<List<Dish>> findByGroup(String groupName) {
        return dishRepository.findDishByGroup(groupName);
    }

    @Transactional
    public Optional<Dish> updateDish(Dish dish, long id) {
        Optional<Dish> optionalDish = findById(id);
        if (optionalDish.isPresent()) {
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
