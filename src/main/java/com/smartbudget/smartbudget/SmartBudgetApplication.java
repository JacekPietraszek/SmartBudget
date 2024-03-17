package com.smartbudget.smartbudget;

import com.smartbudget.smartbudget.transaction.TransactionDtoMapper;
import com.smartbudget.smartbudget.transaction.TransactionRepository;
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
        ConfigurableApplicationContext context = SpringApplication.run(SmartBudgetApplication.class, args);
        TransactionRepository transactionRepository = context.getBean(TransactionRepository.class);
        TransactionDtoMapper transactionDtoMapper = context.getBean(TransactionDtoMapper.class);
//        TransactionDto newTrans = new TransactionDto.Builder()
//                .transactionType(TransactionType.EXPENSE)
//                .account("1234 1234 1234 1234")
//                .comments("komentarz")
//                .dateAdded(Date.from(Instant.now()))
//                .value(100d)
//                .category("mieszkanie")
//                .build();
//
//        transactionRepository.save(transactionDtoMapper.toEntity(newTrans));
    }

}
