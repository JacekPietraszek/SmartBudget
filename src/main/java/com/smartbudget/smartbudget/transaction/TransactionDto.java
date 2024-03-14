package com.smartbudget.smartbudget.transaction;


import java.util.Date;

public class TransactionDto {
    private final Long id;
    private final String typeOfTransaction;
    private final String category;
    private final Double value;
    private final String account;
    private final Date dateAdded;
    private final String comments;

    private TransactionDto(Builder builder) {
        this.id = builder.id;
        this.typeOfTransaction = builder.typeOfTransaction;
        this.comments = builder.comments;
        this.account = builder.account;
        this.dateAdded = builder.dateAdded;
        this.value = builder.value;
        this.category = builder.category;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public Double getValue() {
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
        private String typeOfTransaction;
        private String category;
        private Double value;
        private String account;
        private Date dateAdded;
        private String comments;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return Builder.this;
        }

        public Builder typeOfTransaction(String typeOfTransaction) {
            this.typeOfTransaction = typeOfTransaction;
            return Builder.this;
        }

        public Builder category(String category) {
            this.category = category;
            return Builder.this;
        }

        public Builder value(Double value) {
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
            if (this.typeOfTransaction == null) {
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
