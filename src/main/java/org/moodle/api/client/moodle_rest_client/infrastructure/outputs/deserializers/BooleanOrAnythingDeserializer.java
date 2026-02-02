package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class BooleanOrAnythingDeserializer extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonToken currentToken = p.getCurrentToken();

        // 1. Si ya es un Booleano nativo en JSON
        if (currentToken == JsonToken.VALUE_TRUE) return Boolean.TRUE;
        if (currentToken == JsonToken.VALUE_FALSE) return Boolean.FALSE;

        // 2. Si viene como un número (ej. Moodle enviando 1 o 0)
        if (currentToken == JsonToken.VALUE_NUMBER_INT) {
            return p.getIntValue() != 0; // Cualquier cosa distinta de 0 es true
        }

        // 3. Si viene como un String (ej. "true", "1", "false", "0")
        if (currentToken == JsonToken.VALUE_STRING) {
            String text = p.getText().trim().toLowerCase();
            if ("true".equals(text) || "1".equals(text)) return Boolean.TRUE;
            if ("false".equals(text) || "0".equals(text)) return Boolean.FALSE;
        }

        // 4. Si es nulo o cualquier otra cosa
        if (currentToken == JsonToken.VALUE_NULL) return null;

        return null;
    }
}