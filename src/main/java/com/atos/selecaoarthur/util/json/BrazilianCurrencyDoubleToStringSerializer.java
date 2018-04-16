package com.atos.selecaoarthur.util.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * TODO Document class
 */
public class BrazilianCurrencyDoubleToStringSerializer extends StdSerializer<Double> {

    private final DecimalFormat df;

    public BrazilianCurrencyDoubleToStringSerializer() {
        this(null);
    }

    protected BrazilianCurrencyDoubleToStringSerializer(Class<Double> t) {
        super(t);

        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.getDefault());
        formatSymbols.setDecimalSeparator(',');

        df = new DecimalFormat("####,####.00", formatSymbols);
        df.setMaximumFractionDigits(2);
        df.setDecimalSeparatorAlwaysShown(true);
        df.setGroupingUsed(false);
    }

    @Override
    public void serialize(Double value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {

        gen.writeString(df.format(value));
    }
}
