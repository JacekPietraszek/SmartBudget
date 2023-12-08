package com.smartbudget.smartbudget.transaction;

import java.time.LocalDateTime;

public class TransactionDto {
    private Long id;
    private String TypeOfTransaction;
    private String category;
    private Double amount;
    private String account;
    private LocalDateTime dateAdded;
    private String comments;

    public String getTypeOfTransaction() {
        return TypeOfTransaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        TypeOfTransaction = typeOfTransaction;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
