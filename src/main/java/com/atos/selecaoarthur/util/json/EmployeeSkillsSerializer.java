package com.atos.selecaoarthur.util.json;

import com.atos.selecaoarthur.model.Skill;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.List;

public class EmployeeSkillsSerializer extends StdSerializer<List<Skill>> {

    public EmployeeSkillsSerializer() {
        this(null);
    }

    protected EmployeeSkillsSerializer(Class<List<Skill>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Skill> skills, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartArray();

        for(Skill skill : skills) {
            gen.writeString(skill.getName());
        }

        gen.writeEndArray();
    }
}
