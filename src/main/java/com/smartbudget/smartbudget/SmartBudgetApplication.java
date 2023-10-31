package com.smartbudget.smartbudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SmartBudgetApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SmartBudgetApplication.class, args);

    }

}
