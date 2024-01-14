package com.smartbudget.smartbudget.transaction;


import java.util.Date;

public class TransactionDto {
    private Long id;
    private String TypeOfTransaction;
    private String category;
    private Double value;
    private String account;
    private Date dateAdded;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
