package com.atos.selecaoarthur.util.json;

import com.atos.selecaoarthur.model.Certification;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.List;

public class EmployeeCertificationsSerializer extends StdSerializer<List<Certification>> {

    public EmployeeCertificationsSerializer() {
        this(null);
    }

    protected EmployeeCertificationsSerializer(Class<List<Certification>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Certification> certifications,
                          JsonGenerator gen,
                          SerializerProvider provider)
            throws IOException {

        gen.writeStartArray();

        for (Certification certification : certifications) {
            gen.writeString(certification.getName());
        }

        gen.writeEndArray();
    }
}
