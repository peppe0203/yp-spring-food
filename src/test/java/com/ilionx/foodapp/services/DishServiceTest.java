package com.ilionx.foodapp.services;

import com.ilionx.foodapp.models.Dish;
import com.ilionx.foodapp.repositories.DishRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Mocks is onderdeel van mockito

@ExtendWith(MockitoExtension.class)
public class DishServiceTest {

    @InjectMocks
    private DishService dishService;

    @Mock
    private DishRepository dishRepository;

    // Unit test
    @Test
    public void testSave(){
        Dish newDish = new Dish();

        newDish.setName("Pesto speciale");
        newDish.setGroupName("pasta");
        newDish.setDescription("Nice pasta pesto with extra cheese");
        newDish.setPrice(13.50);

        Mockito.when(this.dishRepository.save(newDish)).thenReturn(newDish);

        Dish result = this.dishService.save(newDish);
        assertEquals("Pesto speciale",result.getName());
    }

    // Unit test
    @Test
    public void testFindAll(){
        Dish dish = new Dish();

        // If the next line is commented result returns 0 instead of 1.
        Mockito.when(this.dishRepository.findAll()).thenReturn(Collections.singletonList(dish));

        List<Dish> resultFromService = this.dishService.findAll();
        assertEquals(1, resultFromService.size());
    }

}
