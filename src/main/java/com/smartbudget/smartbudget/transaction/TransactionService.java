package com.smartbudget.smartbudget.transaction;

import org.springframework.stereotype.Service;


@Service
public class TransactionService {
    private TransactionRepository transactionRepository;
    private TransactionDtoMapper transactionDtoMapper;

    public TransactionService(TransactionRepository transactionRepository, TransactionDtoMapper transactionDtoMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionDtoMapper = transactionDtoMapper;
    }

    public TransactionDto saveTransaction(TransactionDto transactionDto) {
        Transaction transactionToSave = transactionDtoMapper.map(transactionDto);
        Transaction savedTransaction = transactionRepository.save(transactionToSave);
        return transactionDtoMapper.map(savedTransaction);
    }
}
