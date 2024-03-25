package com.smartbudget.smartbudget.transaction;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
public class TransactionController {

    private final TransactionService transactionService;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction")
    public String addTransaction(@RequestBody TransactionDto transactionDto) {
        Set<ConstraintViolation<TransactionDto>> errors = validator.validate(transactionDto);
        errors.forEach(error -> System.err.println(error.getPropertyPath() + " " + error.getMessage()));
        TransactionDto savedTransaction = transactionService.saveTransaction(transactionDto);
        return "Object id: " + savedTransaction.getId() + " added to database";
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable Long id) {
        TransactionDto transactionDto = transactionService.getTransactionById(id);
        return ResponseEntity.ok(transactionDto);
    }

    // todo paginacja spring pagination
    @GetMapping("/transaction")
    List<TransactionDto> findAll(@RequestParam(required = false) String category) {
        if (category != null) {
            return transactionService.findAllByCategory(category);
        } else {
            return transactionService.getAllTransactions();
        }
    }
}
