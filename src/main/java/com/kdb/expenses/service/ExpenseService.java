package com.kdb.expenses.service;

import com.kdb.expenses.domain.ExpenseEntity;
import com.kdb.expenses.domain.Repository;
import com.kdb.expenses.domain.IRepository;
import com.kdb.expenses.service.dto.ExpenseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService implements IExpenseService {

    IRepository repo = new Repository();

    @Override
    public Long CreateExpenseRecord(ExpenseDTO expense) {
        Long expenseId = 123l;
        return expenseId;
    }

    @Override
    public List<ExpenseDTO> GetExpensesForClient(long clientId) {
        List<ExpenseEntity> entities = repo.GetExpensesByClientId(clientId);
        return entities.stream().map(x -> Map(x)).collect(Collectors.toList());
    }

    private ExpenseDTO Map(ExpenseEntity entity) {
        return new ExpenseDTO(entity.getClientID(), entity.getDate() ,entity.getAmount() );
    }
}
