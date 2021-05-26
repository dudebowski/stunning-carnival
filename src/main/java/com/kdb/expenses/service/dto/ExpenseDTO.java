package com.kdb.expenses.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseDTO {

    public ExpenseDTO() {
    }

    public ExpenseDTO(Long clientId, Date date, BigDecimal amount) {
        this.clientId = clientId;
        this.date = date;
        this.amount = amount;
    }

    @JsonProperty("client_id")
    public Long getClientId() {
        return clientId;
    }

    @JsonProperty("client_id")
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @JsonProperty("date")
    public Date getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(Date date) {
        this.date = date;
    }

    @JsonProperty("amount")
    public BigDecimal getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private Long clientId;

    private Date date;

    private BigDecimal amount;
}
