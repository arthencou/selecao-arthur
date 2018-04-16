package com.atos.selecaoarthur.util.json;

import com.atos.selecaoarthur.model.Skill;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSkillsDeserializer extends StdDeserializer<List<Skill>> {

    private final ObjectMapper om;
    private final CollectionType type;

    public EmployeeSkillsDeserializer() {
        this(null);
    }

    protected EmployeeSkillsDeserializer(Class<?> vc) {
        super(vc);

        om = new ObjectMapper();
        type = om.getTypeFactory().constructCollectionType(List.class, Skill.class);
    }

    @Override
    public List<Skill> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        String text = p.getText();

        if (text != null) {
            try {
                //Trying with default deserializer
                return om.readValue(text, type);

            } catch (IOException e) {

                //If failed, assume comma separated skill names
                String[] split = text.split(",");
                return Arrays.stream(split)
                        .map(Skill::new)
                        .collect(Collectors.toList());
            }
        }

        return null;
    }
}
