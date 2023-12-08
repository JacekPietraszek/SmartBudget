package com.smartbudget.smartbudget.transaction;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private final ObjectMapper objectMapper;

    public TransactionController(TransactionService transactionService, ObjectMapper objectMapper) {
        this.transactionService = transactionService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/{id}")
    ResponseEntity<TransactionDto> getTransactionById(@PathVariable Long id) {
        return transactionService.getOfferById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<TransactionDto> savedTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto savedTransaction = transactionService.saveTransaction(transactionDto);
        URI savedTransactionUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTransaction.getId())
                .toUri();
        return ResponseEntity.created(savedTransactionUri).body(savedTransaction);
    }




}
