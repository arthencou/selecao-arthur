package com.atos.selecaoarthur.controllers;

import com.atos.selecaoarthur.model.Employee;
import com.atos.selecaoarthur.services.EmployeesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.BDDMockito.willReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeesController.class)
public class EmployeesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeesService employeesService;

    @Test
    public void getEmployees() throws Exception {

        ArrayList<Employee> resource = new ArrayList<Employee>() {{
            add(new Employee() {{setName("Employee1");}});
            add(new Employee() {{setName("Employee2");}});
        }};

        willReturn(resource).given(employeesService).getAllEmployees();

        MvcResult json = this.mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(json.getResponse().getContentAsString()).contains("\"name\":\"Employee1\"");
        assertThat(json.getResponse().getContentAsString()).contains("\"name\":\"Employee2\"");
    }
}