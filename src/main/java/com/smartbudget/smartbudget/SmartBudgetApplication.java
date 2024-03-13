package com.smartbudget.smartbudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//todo przepsianie frontu na jakiś framework (oddzielne repo?)
//todo controller przez który można pobrać kategorie dLA DANEGO TYPU TRANSAKCJI
//todo spring security (user)
//todo dodanie lomboka?
//todo ładowanie danych testowych na starcie, resources/data.sql
@SpringBootApplication
public class SmartBudgetApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartBudgetApplication.class, args);
    }

}
