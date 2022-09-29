package com.ilionx.foodapp.testing;

import com.ilionx.foodapp.models.Dish;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;


// This name cannot end with Test because it is an integration test, and we don't want to run this with test.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("Integrationtest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DishControllerIT {

    // The restTemplate makes the CRUD (CREATE, GET, PUT, DELETE) functionalities possible
    @Autowired
    public TestRestTemplate restTemplate;
    private static long currentId = -1;


    // The next test is for initialisation the basic database
    @Test
    @Order(0)
    public void setup() {
        Dish dish1 = new Dish();
        dish1.setName("Pesto speciale");
        dish1.setGroupName("pasta");
        dish1.setDescription("Nice pasta pesto with extra cheese");
        dish1.setPrice(13.50);
        this.restTemplate.postForEntity("/dish", dish1, Dish.class);

        Dish dish2 = new Dish();
        dish2.setName("Pepperoni");
        dish2.setGroupName("pizza");
        dish2.setDescription("Pizza salami but spicy");
        dish2.setPrice(11.18);
        this.restTemplate.postForEntity("/dish", dish2, Dish.class);
    }

    @Test
    @Order(1)
    public void testFindAll() {
        ResponseEntity<dishList> allDishes = this.restTemplate.getForEntity("/dish", dishList.class);
        assertEquals(2, allDishes.getBody().stream().count());
    }

    private static class dishList extends ArrayList<Dish> {
    }

    @Test
    @Order(2)
    public void testSaving() {
        Dish newDish = new Dish();
        newDish.setName("Pesto speciale");
        newDish.setGroupName("pasta");
        newDish.setDescription("Nice pasta pesto with extra cheese");
        newDish.setPrice(13.50);

        ResponseEntity<Dish> response = this.restTemplate.postForEntity("/dish", newDish, Dish.class);

        assertEquals(201, response.getStatusCodeValue());

        Dish returnedDish = response.getBody();
        assertNotNull(returnedDish);

        // Test if there is an id for the dish
        assertNotEquals(0, returnedDish.getId());
        assertEquals("Pesto speciale", returnedDish.getName());
        currentId = returnedDish.getId();
    }

    @Test
    @Order(3)
    public void testFindById(){
        long id = 1;
        ResponseEntity<Dish> response = this.restTemplate.getForEntity("/dish/" + 1, Dish.class);
        assertEquals(1, response.getBody().getId());
        assertEquals("Pesto speciale", response.getBody().getName());
    }

    // Count amount of dishes and delete one, count again and this needs to be equal + 1
    @Test
    @Order(4)
    public void testDeleteById(){
        dishList allDishes = this.restTemplate.getForEntity("/dish", dishList.class).getBody();
        long orgAmountDishes = allDishes.stream().count();

        this.restTemplate.delete("/dish/1");

        dishList allDishesMinOne = this.restTemplate.getForEntity("/dish", dishList.class).getBody();
        long newAmountDishes = allDishesMinOne.stream().count();
        assertEquals(orgAmountDishes, newAmountDishes + 1);
    }
}
