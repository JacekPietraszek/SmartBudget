package com.smartbudget.smartbudget.transaction;

import org.springframework.stereotype.Service;

@Service
public class TransactionDtoMapper {

    public TransactionDto toDto(Transaction transaction) {
        return new TransactionDto.Builder()
                .id(transaction.getId())
                .transactionType(transaction.getTransactionType())
                .category(transaction.getCategory())
                .value(transaction.getValue())
                .account(transaction.getAccount())
                .dateAdded(transaction.getDateAdded())
                .comments(transaction.getComments())
                .build();
    }

    public Transaction toEntity(TransactionDto dto) {
        Transaction transaction = new Transaction();
        transaction.setId(dto.getId());
        transaction.setAccount(dto.getAccount());
        transaction.setValue(dto.getValue());
        transaction.setCategory(dto.getCategory());
        transaction.setDateAdded(dto.getDateAdded());
        transaction.setTransactionType(dto.getTransactionType());
        transaction.setComments(dto.getComments());
        return transaction;
    }
}
