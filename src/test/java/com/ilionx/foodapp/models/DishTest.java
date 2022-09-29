package com.ilionx.foodapp.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DishTest {

    private Dish dish;

    @Test
    public void testGetSetName(){
        dish = new Dish();
        dish.setName("Pesto");

        // Working wit JUnit5
        assertEquals("Pesto", dish.getName());
    }
}
