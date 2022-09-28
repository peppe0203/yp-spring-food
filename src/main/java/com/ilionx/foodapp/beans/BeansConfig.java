package com.ilionx.foodapp.beans;

import com.ilionx.foodapp.models.Cook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public Cook chefCook(){
        Cook youri = new Cook();
        youri.setName("Youri Dera");
        return youri;
    }

    @Bean
    public Cook assistantCook(){
        Cook joop = new Cook();
        joop.setName("Joop Hak");
        return joop;
    }
}
