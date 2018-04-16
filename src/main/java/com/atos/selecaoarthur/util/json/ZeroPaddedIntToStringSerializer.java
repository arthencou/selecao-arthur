package com.atos.selecaoarthur.util.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * TODO Document class
 */
public class ZeroPaddedIntToStringSerializer extends StdSerializer<Integer> {

    public ZeroPaddedIntToStringSerializer() {
        this(null);
    }

    public ZeroPaddedIntToStringSerializer(Class<Integer> t) {
        super(t);
    }

    @Override
    public void serialize(Integer value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(String.format("%02d", value));
    }
}
