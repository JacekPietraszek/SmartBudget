package com.smartbudget.smartbudget.transaction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactionController {


    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/addTransaction")
    public String addTransaction(TransactionDto transactionDto, Model model) {
        TransactionDto savedTransaction = transactionService.saveTransaction(transactionDto);
        model.addAttribute("transactionDto", savedTransaction);
        return "newtransaction";
    }
}
