package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.MoodleCredentialsDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Slf4j
public class MoodleHttpClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public MoodleHttpClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public <T> T call(MoodleCredentialsDTO moodleCredentials, String wsFunction, Map<String, Object> body, Class<T> responseType) {
        String url = moodleCredentials.getUrl();
        String token = moodleCredentials.getWstoken();
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        // Validar que la URL termine con el endpoint correcto de Moodle
        if (!url.matches(".*webservice/rest/server\\.php$")) {
            throw new MoodleApiException("Invalid endpoint URL. It must end with '/webservice/rest/server.php'. Current URL: " + url);
        }

        log.info("Calling Moodle function: {} at URL: {}", wsFunction, url);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("wstoken", token);
        requestBody.add("wsfunction", wsFunction);
        requestBody.add("moodlewsrestformat", "json");

        if (body != null) {
            flattenMap(body, requestBody);
        }

        log.info("Request body: {}", requestBody);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestBody, headers);

        JsonNode responseNode = null;
        try {
            // 1. We get the response as a generic JsonNode to be able to inspect it
            responseNode = restTemplate.postForObject(url, request, JsonNode.class);

            // 2. We check if the response is actually a Moodle error
            checkForMoodleError(responseNode);

            // 3. If it's not an error, we convert it to the expected DTO type
            return objectMapper.treeToValue(responseNode, responseType);

        } catch (HttpClientErrorException e) {
            log.error("HTTP Client Error: {}", e.getMessage());
            throw new MoodleApiException(parseMoodleError(e), e);
        } catch (RestClientException e) {
            log.error("REST Client Error: {}", e.getMessage());
            throw new MoodleApiException("Communication error with Moodle server: " + e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error("FATAL PARSING ERROR: The Moodle response does not match the DTO structure.");
            if (responseNode != null) {
                log.error("Raw JSON response from Moodle: {}", responseNode.toPrettyString());
            }
            throw new MoodleApiException("Error mapping Moodle response to DTO: " + e.getMessage(), e);
        } catch (IOException e) {
            log.error("IO Error processing response: {}", e.getMessage());
            throw new MoodleApiException("Error processing response from Moodle server: " + e.getMessage(), e);
        } catch (Exception e) {
            log.error("Unexpected error in MoodleHttpClient.call: {}", e.getMessage(), e);
            throw e;
        }
    }

    private void flattenMap(Map<String, Object> source, MultiValueMap<String, String> target) {
        for (Map.Entry<String, Object> entry : source.entrySet()) {
            flattenValue(entry.getValue(), target, entry.getKey());
        }
    }

    private void flattenValue(Object value, MultiValueMap<String, String> target, String key) {
        if (value == null) return;

        if (value instanceof List) {
            List<?> list = (List<?>) value;
            for (int i = 0; i < list.size(); i++) {
                flattenValue(list.get(i), target, key + "[" + i + "]");
            }
        } else if (value.getClass().isPrimitive() || value instanceof String || value instanceof Number || value instanceof Boolean) {
            target.add(key, value.toString());
        } else {
            Field[] fields = value.getClass().getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object fieldValue = field.get(value);
                    if (fieldValue != null) {
                        flattenValue(fieldValue, target, key + "[" + field.getName() + "]");
                    }
                } catch (IllegalAccessException e) {
                    // Ignore
                }
            }
        }
    }

    private void checkForMoodleError(JsonNode responseNode) {
        if (responseNode != null && (responseNode.has("exception") || responseNode.has("errorcode"))) {
            String exception = responseNode.has("exception") ? responseNode.get("exception").asText() : "N/A";
            String errorCode = responseNode.has("errorcode") ? responseNode.get("errorcode").asText() : "N/A";
            String message = responseNode.has("message") ? responseNode.get("message").asText() : "No message provided.";
            log.warn("Moodle API error detected: {} ({}) - {}", errorCode, exception, message);
            throw new MoodleApiException(String.format("Moodle Error: %s (%s) - %s", errorCode, exception, message));
        }
    }

    private String parseMoodleError(HttpClientErrorException e) {
        try {
            JsonNode errorNode = objectMapper.readTree(e.getResponseBodyAsString());
            return String.format("Moodle Error: %s - %s", errorNode.path("errorcode").asText(), errorNode.path("message").asText());
        } catch (IOException ioException) {
            return e.getMessage();
        }
    }
}