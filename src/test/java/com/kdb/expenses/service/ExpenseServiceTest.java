package com.kdb.expenses.service;

import com.kdb.expenses.domain.ExpenseEntity;
import com.kdb.expenses.domain.IRepository;
import com.kdb.expenses.service.dto.ExpenseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.containsString;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ExpenseServiceTest {

    @MockBean
    private IRepository repository;

    @Test
    public void getExpensesByClientId() throws Exception {
        List<ExpenseEntity> entities = new ArrayList() {{
            add (new ExpenseEntity(44L,20L, Calendar.getInstance().getTime(), new BigDecimal("34.89")));
            add (new ExpenseEntity(45L,20L, Calendar.getInstance().getTime(), new BigDecimal("134.17")));
            add (new ExpenseEntity(46L,20L, Calendar.getInstance().getTime(), new BigDecimal("124.45")));
            add (new ExpenseEntity(47L,20L, Calendar.getInstance().getTime(), new BigDecimal("88.83")));
            add (new ExpenseEntity(47L,30L, Calendar.getInstance().getTime(), new BigDecimal("55.66")));
            add (new ExpenseEntity(49L,30L, Calendar.getInstance().getTime(), new BigDecimal("36.77")));
            add (new ExpenseEntity(50L,40L, Calendar.getInstance().getTime(), new BigDecimal("123.45")));
            add (new ExpenseEntity(51L,55l, Calendar.getInstance().getTime(), new BigDecimal("879.33")));
        }};


        when(repository.GetExpensesByClientId(20l))
                .thenReturn(entities.stream()
                        .filter(d -> d.getClientID()==20l)
                        .collect(Collectors.toList()));

        IExpenseService service = new ExpenseService();
        List<ExpenseDTO> actual = service.GetExpensesForClient(20l);
        assertThat(actual.size()).isEqualTo(4);

        Function<ExpenseDTO, BigDecimal> totalMapper = expense -> expense.getAmount();
        BigDecimal sum = actual.stream()
                .map(totalMapper)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        assertThat(sum).isEqualTo(new BigDecimal("382.34"));

    }
}