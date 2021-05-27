package com.kdb.expenses.domain;

import com.kdb.expenses.service.dto.ExpenseDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class Repository implements IRepository {

    public Repository() {
    }

    @Override
    public List<ExpenseEntity> GetExpensesByClientId(Long clientId) {
        return getData().stream()
                .filter(d -> d.getClientID() == 20l)
                .collect(Collectors.toList());
    }

    @Override
    public Long AddExpense(ExpenseDTO dto) {
        return null;
    }

    public List<ExpenseEntity> getData() {
        List<ExpenseEntity> data = new ArrayList() {{
            add(new ExpenseEntity(44L, 20L, Calendar.getInstance().getTime(), new BigDecimal(34.89)));
            add(new ExpenseEntity(45L, 20L, Calendar.getInstance().getTime(), new BigDecimal(134.17)));
            add(new ExpenseEntity(46L, 20L, Calendar.getInstance().getTime(), new BigDecimal(124.45)));
            add(new ExpenseEntity(47L, 20L, Calendar.getInstance().getTime(), new BigDecimal(88.83)));
            add(new ExpenseEntity(47L, 30L, Calendar.getInstance().getTime(), new BigDecimal(55.66)));
            add(new ExpenseEntity(49L, 30L, Calendar.getInstance().getTime(), new BigDecimal(36.77)));
            add(new ExpenseEntity(50L, 40L, Calendar.getInstance().getTime(), new BigDecimal(123.45)));
            add(new ExpenseEntity(51L, 55l, Calendar.getInstance().getTime(), new BigDecimal(879.33)));
        }};
        return data;
    }
}
