package com.kdb.expenses.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseEntity {

    private Long id;
    private Long clientID;
    private BigDecimal amount;
    private Date date;

    public ExpenseEntity(Long id, Long clientID, Date date,BigDecimal amount ) {
        this.id = id;
        this.clientID = clientID;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setData(Date data) {
        this.date = date;
    }
}
