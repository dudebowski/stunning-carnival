package com.kdb.expenses.web;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.kdb.expenses.service.IExpenseService;
import com.kdb.expenses.service.dto.ExpenseDTO;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc//(addFilters = false)
public class ExpenseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IExpenseService service;

    @Test
    public void getExpenseShouldReturnAmount() throws Exception {
        when(service.GetExpensesForClient(20)).thenReturn(new BigDecimal(289.67));

        this.mockMvc.perform(get("/expenses/client/20"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(content().string(containsString("289.67")));
    }

    @Test
    public void postExpense() throws Exception {
        when(service.CreateExpenseRecord(any(ExpenseDTO.class))).thenReturn(123l);
        String json = "{\"client_id\" : 1234, \"date\" : \"2021-05-23T18:25:43.511Z\", \"amount\" : 67.45}";
        this.mockMvc.perform(post("/expenses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status()
                        .isCreated())
                .andExpect(content().string(containsString("123")));
    }
}
