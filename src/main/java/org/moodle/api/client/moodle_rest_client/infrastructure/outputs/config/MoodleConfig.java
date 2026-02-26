package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client.MoodleHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

@Configuration
public class MoodleConfig {

    @Bean
    public RestTemplate restTemplate(ObjectMapper objectMapper) {

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(5000); // 5 segundos
        factory.setReadTimeout(3 * 60000); // 3 minutos

        RestTemplate restTemplate = new RestTemplate(factory);
        // Añadir ambos convertidores: JSON para leer respuestas, Form para enviar peticiones
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter(objectMapper));
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());

        return restTemplate;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return objectMapper;
    }

    @Bean
    public MoodleHttpClient moodleHttpClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
        return new MoodleHttpClient(restTemplate, objectMapper);
    }
}
