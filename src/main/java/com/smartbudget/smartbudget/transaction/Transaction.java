package com.smartbudget.smartbudget.transaction;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    //todo manyToOne? jak już będzie tabelka z kategoriami to tutaj powinno być powiązanie
    @Column
    private String category;
    //todo value_transaction -> value, nazwa kolumny (jak będziesz to zmieniał to rób bardzo małe zmiany i obserwuj czy sie baza nie wywala)
    // nie przechowujemy pieniędzy jako double https://gist.github.com/kpgalligan/dd5fa2237f271a138f91 -> typ Money, może być @Embeddable
    @Column(name= "value_transaction")
    private Double value;
    @Column
    private String account;
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Column
    private String comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
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
