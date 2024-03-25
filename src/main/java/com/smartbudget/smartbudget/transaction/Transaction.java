package com.smartbudget.smartbudget.transaction;

import com.smartbudget.smartbudget.money.Money;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Date;


@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private TransactionType transactionType;
    //todo manyToOne? jak już będzie tabelka z kategoriami to tutaj powinno być powiązanie
    @Column
    private String category;
    //todo value_transaction -> value, nazwa kolumny (jak będziesz to zmieniał to rób bardzo małe zmiany i obserwuj czy sie baza nie wywala)
    // nie przechowujemy pieniędzy jako double https://gist.github.com/kpgalligan/dd5fa2237f271a138f91 -> typ Money, może być @Embeddable
    @Embedded
    private Money value;
    @Column
    private String account;
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Column
    @Size(min = 0, max = 200, message = "Comments must be between 0 and 200 characters.")
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

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
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
