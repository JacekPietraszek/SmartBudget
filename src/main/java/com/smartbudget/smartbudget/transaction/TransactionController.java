package com.smartbudget.smartbudget.transaction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    // todo nazewnictwo endpointów
    @PostMapping("/transaction")
    public String addTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto savedTransaction = transactionService.saveTransaction(transactionDto);
        return "Object added to database.";
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
