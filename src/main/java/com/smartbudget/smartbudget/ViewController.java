package com.smartbudget.smartbudget;

import com.smartbudget.smartbudget.transaction.Transaction;
import com.smartbudget.smartbudget.transaction.TransactionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    private TransactionRepository transactionRepository;

    public ViewController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/addTransaction")
    public String addTransaction(@ModelAttribute Transaction transaction, Model model) {
        Transaction transaction1 = transactionRepository.save(transaction);
        model.addAttribute("message", transaction1.getId() + "inserted.");
        return "newtransaction";
    }
}
