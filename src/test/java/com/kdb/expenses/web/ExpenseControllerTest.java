package com.kdb.expenses.web;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.kdb.expenses.service.IExpenseService;
import com.kdb.expenses.service.dto.ExpenseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc//(addFilters = false)
public class ExpenseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IExpenseService service;

    @Test
    public void getExpenseShouldReturnList() throws Exception {
        List<ExpenseDTO> dtos = new ArrayList() {{
            add (new ExpenseDTO(20L, Calendar.getInstance().getTime(), new BigDecimal("34.89")));
            add (new ExpenseDTO(20L, Calendar.getInstance().getTime(), new BigDecimal("26.33")));
            add (new ExpenseDTO(20L, Calendar.getInstance().getTime(), new BigDecimal("34.89")));
            add (new ExpenseDTO(20L, Calendar.getInstance().getTime(), new BigDecimal("34.89")));
            add (new ExpenseDTO(20L, Calendar.getInstance().getTime(), new BigDecimal("34.89")));
        }};

        when(service.GetExpensesForClient(20)).thenReturn(dtos);

        this.mockMvc.perform(get("/expenses/client/20"))
                .andDo(print())
                .andExpect(status()
                        .isOk());
    }

    @Test
    public void postExpenseHappyFlow() throws Exception {
        when(service.CreateExpenseRecord(any(ExpenseDTO.class))).thenReturn(123l);
        String json = "{\"client_id\" : 1234, \"date\" : \"2021-05-23T18:25:43.511Z\", \"amount\" : \"67.45\"}";
        this.mockMvc.perform(post("/expenses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status()
                        .isCreated())
                .andExpect(content().string(containsString("123")));
    }

    @Test
    public void postExpenseWrongDecimalSeparatorReturn400() throws Exception {
        String json = "{ \"date\" : \"2021-05-23T18:25:43.511Z\", \"amount\" : \"67,45\"}";
        this.mockMvc.perform(post("/expenses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status()
                        .isBadRequest());
    }

    @Test
    public void postExpenseWrongDateReturn400() throws Exception {
        String json = "{ \"date\" : \"2021-23-mayT18:25:43.511Z\", \"amount\" : \"67,45\"}";
        this.mockMvc.perform(post("/expenses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status()
                        .isBadRequest());
    }

    @Test
    public void postExpenseWrongMethodReturn405() throws Exception {
        //when(service.CreateExpenseRecord(any(ExpenseDTO.class))).thenReturn(123l);
        String json = "{ \"date\" : \"2021-23-mayT18:25:43.511Z\", \"amount\" : \"67,45\"}";
        this.mockMvc.perform(post("/expenses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status()
                        .isBadRequest());
    }

    //required json property is not working
    //2021-23-23T18:25:43.511Z is an accpetable date
}
