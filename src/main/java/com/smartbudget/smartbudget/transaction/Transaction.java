package com.smartbudget.smartbudget.transaction;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "type_of_transaction")
    private String typeOfTransaction;
    @Column
    private String category;
    @Column(name= "value_transaction")
    private Double value;
    @Column
    private String account;
    @Column(name = "date_added")
    private String dateAdded;
    @Column
    private String comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
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

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", typeOfTransaction='" + typeOfTransaction + '\'' +
                ", category='" + category + '\'' +
                ", value=" + value +
                ", account='" + account + '\'' +
                ", dateAdded=" + dateAdded +
                ", comments='" + comments + '\'' +
                '}';
    }
}
