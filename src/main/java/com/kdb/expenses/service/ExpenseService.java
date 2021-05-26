package com.kdb.expenses.service;

import com.kdb.expenses.service.dto.ExpenseDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExpenseService implements IExpenseService {

    @Override
    public Long CreateExpenseRecord(ExpenseDTO expense) {
        Long expenseId = 123l;
        return expenseId;
    }

    @Override
    public BigDecimal GetExpensesForClient(long clientID) {
        return new BigDecimal(123.45);
    }
}
