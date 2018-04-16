package com.atos.selecaoarthur.util.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * TODO Document class
 */
public class BrazilianCurrencyStringToDoubleDeserializer extends StdDeserializer<Double> {

    public BrazilianCurrencyStringToDoubleDeserializer() {
        this(null);
    }

    protected BrazilianCurrencyStringToDoubleDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Double deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        String asString = p.getText();
        if (asString.contains(",")) {
            asString = asString.replace(",", ".");
        }
        return Double.parseDouble(asString);
    }
}
