package com.atos.selecaoarthur.util.json;

import com.atos.selecaoarthur.model.Employee.EmployeeRole;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.util.Arrays;

//TODO Document class
public class EmployeeRoleDesserializer extends StdDeserializer<EmployeeRole> {

    public EmployeeRoleDesserializer() {
        this(null);
    }

    protected EmployeeRoleDesserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public EmployeeRole deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        String text = p.getText();

        EmployeeRole employeeRole = Arrays.stream(EmployeeRole.values())
                .filter(role -> role.getRoleName().equals(text))
                .findFirst()
                .orElse(null);

        if (employeeRole == null)
            fail(p, text, ctxt);

        return employeeRole;
    }

    private void fail(JsonParser p, String text, DeserializationContext ctxt)
            throws InvalidFormatException {

        String enums = Arrays.toString(EmployeeRole.values());

        String msg = String.format(
                "value not one of declared Enum instance names: %s",
                String.join(",", enums));

        throw new com.fasterxml.jackson.databind.exc.InvalidFormatException(p, msg, text, ctxt.getActiveView());
    }

}
