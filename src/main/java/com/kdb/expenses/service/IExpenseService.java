package com.kdb.expenses.service;

import com.kdb.expenses.service.dto.ExpenseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IExpenseService {
    public Long CreateExpenseRecord(ExpenseDTO expense);
    public List<ExpenseDTO> GetExpensesForClient(long clientID);
}
