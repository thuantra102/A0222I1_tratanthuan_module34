package com.example.doodling_funamental_spring_boot;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CreateBean {
    @Bean
    public void helloBean() {
//        System.out.println("hello i am bean");
    }
    @Bean
    public void  helloBean2() {
//        System.out.println("hello i am bean 2");
    }
    @Bean
    public String getName() {
//        System.out.println("hello get name bean is created");
        return "Hola arigato go sai sima";
    }


}
