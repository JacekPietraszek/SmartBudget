package com.smartbudget.smartbudget.transaction;

import org.springframework.stereotype.Service;

@Service
public class TransactionDtoMapper {

    TransactionDto map(Transaction transaction) {
        TransactionDto dto = new TransactionDto();
        dto.setTypeOfTransaction(transaction.getTypeOfTransaction());
        dto.setCategory(transaction.getCategory());
        dto.setAmount(transaction.getAmount());
        dto.setAccount(transaction.getAccount());
        dto.setDateAdded(transaction.getDateAdded());
        dto.setComments(transaction.getComments());
        return dto;
    }

    Transaction map(TransactionDto dto) {
        Transaction transaction = new Transaction();
        transaction.setId(dto.getId());
        transaction.setAccount(dto.getAccount());
        transaction.setAmount(dto.getAmount());
        transaction.setCategory(dto.getCategory());
        transaction.setDateAdded(dto.getDateAdded());
        transaction.setTypeOfTransaction(dto.getTypeOfTransaction());
        return transaction;
    }
}
