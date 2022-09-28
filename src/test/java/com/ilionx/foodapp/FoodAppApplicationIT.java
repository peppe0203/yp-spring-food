package com.ilionx.foodapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest is an integration test when there is Test at the end of the name.

// When editing the name to end with IT, this won't run when in de test fase
// (it wil be like unit test and not integration)
@SpringBootTest
class FoodAppApplicationIT {

	@Test
	void contextLoads() {
	}

}
