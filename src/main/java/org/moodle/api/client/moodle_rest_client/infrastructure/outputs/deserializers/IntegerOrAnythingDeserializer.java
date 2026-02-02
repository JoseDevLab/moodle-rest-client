package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class IntegerOrAnythingDeserializer extends JsonDeserializer<Integer> {
    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonToken currentToken = p.getCurrentToken();

        if (currentToken == JsonToken.VALUE_FALSE) return 0;
        if (currentToken == JsonToken.VALUE_TRUE) return 1;
        if (currentToken == JsonToken.VALUE_NULL) return null;
        if (currentToken == JsonToken.VALUE_NUMBER_INT) return p.getIntValue();

        // Si viene como String "1" o "0"
        if (currentToken == JsonToken.VALUE_STRING) {
            String text = p.getText();
            if ("true".equalsIgnoreCase(text)) return 1;
            if ("false".equalsIgnoreCase(text)) return 0;
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }
}