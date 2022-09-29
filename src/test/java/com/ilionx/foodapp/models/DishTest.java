package com.ilionx.foodapp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DishTest {

    private Dish dish;

    // For every test there wil be a new dish
    @BeforeEach
    public void init(){
        dish = new Dish();
    }

    // Simple unit test
    @Test
    public void testGetSetName(){
        dish.setName("Pesto");

        // Working wit JUnit5
        assertEquals("Pesto", dish.getName());
    }

    // Simple unit test
    @Test void testGetSetGroupName(){
        dish.setGroupName("pizza");
        assertEquals("pizza", dish.getGroupName());
    }
}
