package com.smartbudget.smartbudget.transaction;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.NoSuchElementException;

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

    @PatchMapping("/{id}")
    ResponseEntity<?> updateTransaction(@PathVariable Long id, @RequestBody JsonMergePatch patch) {
        try {
            TransactionDto transaction = transactionService.getOfferById(id).orElseThrow();
            TransactionDto transactionPatcher = applyPatch(transaction, patch);
            transactionService.updateTransaction(transactionPatcher);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.noContent().build();
    }

    private TransactionDto applyPatch(TransactionDto transaction, JsonMergePatch patch) throws JsonProcessingException, JsonPatchException {
        JsonNode transactionNode = objectMapper.valueToTree(transaction);
        JsonNode transactionPatchedNote = patch.apply(transactionNode);
        return objectMapper.treeToValue(transactionPatchedNote, TransactionDto.class);
    }


}
