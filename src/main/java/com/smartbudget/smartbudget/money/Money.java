package com.smartbudget.smartbudget.money;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Embeddable
public class Money {
    private BigDecimal amount;

    public Money() {
        this.amount = BigDecimal.ZERO;
    }

    public Money(BigDecimal amount) {
        this.amount = amount.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount=amount.setScale(2,RoundingMode.HALF_UP);
    }

}
