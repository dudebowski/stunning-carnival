package com.kdb.expenses.web;

import com.kdb.expenses.service.ExpenseService;
import com.kdb.expenses.service.IExpenseService;
import com.kdb.expenses.service.dto.ExpenseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
public class ExpenseController {

    @Autowired
    public IExpenseService service = new ExpenseService();

    @GetMapping("/expenses/client/{id}")
    public List<ExpenseDTO> getExpenses(@PathVariable long id) {
        return service.GetExpensesForClient(id);
    }

    @PostMapping("/expenses")
    public ResponseEntity<Long> postClient( @RequestBody ExpenseDTO body) {
        Long id = service.CreateExpenseRecord(body);
        ResponseEntity<Long> responseEntity = new ResponseEntity(id,HttpStatus.CREATED);
        return responseEntity;
    }
}