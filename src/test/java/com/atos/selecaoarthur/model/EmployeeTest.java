package com.atos.selecaoarthur.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class EmployeeTest {

    /**
     * Tests if the field {@link Employee#gcm} as a JSON is a String
     * with a leading zero.
     */
    @Test
    public void testSerializesWithCorrectGcm() throws Exception {

        Employee employee = new Employee();
        employee.setGcm(5);

        ObjectMapper om = new ObjectMapper();
        String asJson = om.writeValueAsString(employee);

        assertThat(asJson).contains("\"gcm\":\"05\"");
    }

    /**
     * Tests if the field {@link Employee#salary} can be deserialized from
     * a JSON with String (quoted) representation and comma separated
     * decimals.
     */
    @Test
    public void testDeserializesWithCorrectSalary() throws Exception {

        String asJson = "{\"salary\": \"2000,00\"}";

        ObjectMapper om = new ObjectMapper();
        Employee employee = om.readValue(asJson, Employee.class);

        assertThat(employee.getSalary()).isEqualTo(2000.0);
    }

    /**
     * Tests if the field {@link Employee#salary} as a JSON exhibits
     * comma separated decimals as well as keeps the decimal digits even
     * if they are zero.
     */
    @Test
    public void testSerializesWithCorrectSalary() throws Exception {

        Employee employee = new Employee();
        employee.setSalary(2000.0);

        ObjectMapper om = new ObjectMapper();
        String asJson = om.writeValueAsString(employee);

        assertThat(asJson).contains("\"salary\":\"2000,00\"");
    }

    /**
     * Tests if the field {@link Employee#salary} as a JSON exhibits
     * comma separated decimals as well as keeps the decimal digits.
     */
    @Test
    public void testSerializesWithCorrectSalaryCents() throws Exception {

        Employee employee = new Employee();
        employee.setSalary(2123.1);

        ObjectMapper om = new ObjectMapper();
        String asJson = om.writeValueAsString(employee);

        assertThat(asJson).contains("\"salary\":\"2123,10\"");
    }

}