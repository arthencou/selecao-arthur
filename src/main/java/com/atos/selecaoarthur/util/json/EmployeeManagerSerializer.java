package com.atos.selecaoarthur.util.json;

import com.atos.selecaoarthur.model.Employee;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class EmployeeManagerSerializer extends StdSerializer<Employee> {

    public EmployeeManagerSerializer() {
        this(null);
    }

    protected EmployeeManagerSerializer(Class<Employee> t) {
        super(t);
    }

    @Override
    public void serialize(Employee manager, JsonGenerator gen, SerializerProvider provider)
            throws IOException {

        gen.writeString(manager.getName());
    }
}
