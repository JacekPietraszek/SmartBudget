package com.smartbudget.smartbudget.transaction;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

    public TransactionDto getTransactionById(Long id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        Transaction getTransaction = optionalTransaction.get();
        return transactionDtoMapper.map(getTransaction);
    }

    public List<TransactionDto> getAllTransactions() {
        List<Transaction> allTransactions = transactionRepository.findAll();
        return allTransactions.stream()
                .map(transactionDtoMapper::map)
                .collect(Collectors.toList());
    }

    // sum all transaction (income) by day, week, month, year
    // sum all transaction (expense) by day, week, month, year



}
