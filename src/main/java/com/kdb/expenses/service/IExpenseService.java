package com.kdb.expenses.service;

import com.kdb.expenses.service.dto.ExpenseDTO;

import java.math.BigDecimal;

public interface IExpenseService {
    public Long CreateExpenseRecord(ExpenseDTO expense);
    public BigDecimal GetExpensesForClient(long clientID);
}
