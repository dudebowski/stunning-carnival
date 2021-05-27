package com.kdb.expenses.domain;

import com.kdb.expenses.service.dto.ExpenseDTO;


import java.util.List;

public interface IRepository {

    List<ExpenseEntity> GetExpensesByClientId(Long clientID);
    Long AddExpense(ExpenseDTO dto) ;
}
