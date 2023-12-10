package com.smartbudget.smartbudget.transaction;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;
    private TransactionDtoMapper transactionDtoMapper;

    public TransactionService(TransactionRepository transactionRepository, TransactionDtoMapper transactionDtoMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionDtoMapper = transactionDtoMapper;
    }

    Optional<TransactionDto> getOfferById(Long id) {
        return transactionRepository.findById(id).map(transactionDtoMapper::map);
    }

    TransactionDto saveTransaction (TransactionDto transactionDto) {
        Transaction transactionToSave = transactionDtoMapper.map(transactionDto);
        Transaction savedTransaction = transactionRepository.save(transactionToSave);
        return transactionDtoMapper.map(savedTransaction);
    }

    void updateTransaction (TransactionDto transactionDto) {
        Transaction transaction = transactionDtoMapper.map(transactionDto);
        transactionRepository.save(transaction);
    }
}
