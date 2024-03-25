package com.smartbudget.smartbudget.transaction;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartbudget.smartbudget.money.Money;

import java.util.Date;

public class TransactionDto {
    private final Long id;
    private final TransactionType transactionType;
    private final String category;
    private final Money value;
    private final String account;
    private final Date dateAdded;
    private final String comments;

    @JsonCreator
    private TransactionDto(@JsonProperty("id") Long id,
                           @JsonProperty("transactionType") TransactionType transactionType,
                           @JsonProperty("category") String category,
                           @JsonProperty("value") Money value,
                           @JsonProperty("account") String account,
                           @JsonProperty("dateAdded") Date dateAdded,
                           @JsonProperty("comments") String comments) {
        this.id = id;
        this.transactionType = transactionType;
        this.category = category;
        this.value = value;
        this.account = account;
        this.dateAdded = dateAdded;
        this.comments = comments;
    }
    private TransactionDto(Builder builder) {
        this.id = builder.id;
        this.transactionType = builder.transactionType;
        this.comments = builder.comments;
        this.account = builder.account;
        this.dateAdded = builder.dateAdded;
        this.value = builder.value;
        this.category = builder.category;
    }

    public Long getId() {
        return id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public String getCategory() {
        return category;
    }

    public Money getValue() {
        return value;
    }

    public String getAccount() {
        return account;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public String getComments() {
        return comments;
    }

    public static class Builder {

        private Long id;
        private TransactionType transactionType;
        private String category;
        private Money value;
        private String account;
        private Date dateAdded;
        private String comments;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return Builder.this;
        }

        public Builder transactionType(TransactionType transactionType) {
            this.transactionType = transactionType;
            return Builder.this;
        }

        public Builder category(String category) {
            this.category = category;
            return Builder.this;
        }

        public Builder value(Money value) {
            this.value = value;
            return Builder.this;
        }

        public Builder account(String account) {
            this.account = account;
            return Builder.this;
        }

        public Builder dateAdded(Date dateAdded) {
            this.dateAdded = dateAdded;
            return Builder.this;
        }

        public Builder comments(String comments) {
            this.comments = comments;
            return Builder.this;
        }

        public TransactionDto build() {
            if (this.transactionType == null) {
                throw new NullPointerException("The property \"TypeOfTransaction\" is null. "
                        + "Please set the value by \"TypeOfTransaction()\". "
                        + "The properties \"TypeOfTransaction\", \"category\", \"value\", \"account\", \"dateAdded\" and \"comments\" are required.");
            }
            if (this.category == null) {
                throw new NullPointerException("The property \"category\" is null. "
                        + "Please set the value by \"category()\". "
                        + "The properties \"TypeOfTransaction\", \"category\", \"value\", \"account\", \"dateAdded\" and \"comments\" are required.");
            }
            if (this.value == null) {
                throw new NullPointerException("The property \"value\" is null. "
                        + "Please set the value by \"value()\". "
                        + "The properties \"TypeOfTransaction\", \"category\", \"value\", \"account\", \"dateAdded\" and \"comments\" are required.");
            }
            if (this.account == null) {
                throw new NullPointerException("The property \"account\" is null. "
                        + "Please set the value by \"account()\". "
                        + "The properties \"TypeOfTransaction\", \"category\", \"value\", \"account\", \"dateAdded\" and \"comments\" are required.");
            }
            if (this.dateAdded == null) {
                throw new NullPointerException("The property \"dateAdded\" is null. "
                        + "Please set the value by \"dateAdded()\". "
                        + "The properties \"TypeOfTransaction\", \"category\", \"value\", \"account\", \"dateAdded\" and \"comments\" are required.");
            }
            if (this.comments == null) {
                throw new NullPointerException("The property \"comments\" is null. "
                        + "Please set the value by \"comments()\". "
                        + "The properties \"TypeOfTransaction\", \"category\", \"value\", \"account\", \"dateAdded\" and \"comments\" are required.");
            }

            return new TransactionDto(this);
        }
    }
}
