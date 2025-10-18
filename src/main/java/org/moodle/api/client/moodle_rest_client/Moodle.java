package org.moodle.api.client.moodle_rest_client;

import lombok.extern.slf4j.Slf4j;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.config.MoodleApiConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Moodle {

    private static AnnotationConfigApplicationContext context;

    /**
     * Inicializa el contexto de Spring de la librería Moodle.
     * Debe ser llamado una vez al inicio de la aplicación cliente.
     * @param url La URL base del servicio web de Moodle.
     * @param token El token de acceso para la API de Moodle.
     */
    public static void init(String url, String token) {
        if (context == null) {
            log.info("Inicializando contexto de Spring...");
            context = new AnnotationConfigApplicationContext(MoodleRestClientApplication.class);
            setCredentials(url, token);
            log.info("Contexto de Spring inicializado.");
        }
    }

    /**
     * Actualiza las credenciales de Moodle en tiempo de ejecución.
     * @param url La nueva URL base del servicio web de Moodle.
     * @param token El nuevo token de acceso para la API de Moodle.
     */
    public static void setCredentials(String url, String token) {
        if (context == null) {
            throw new IllegalStateException("El contexto de la librería Moodle no ha sido inicializado. Por favor, llama a Moodle.init() primero.");
        }
        MoodleApiConfig apiConfig = context.getBean(MoodleApiConfig.class);
        apiConfig.setApiUrl(url);
        apiConfig.setApiToken(token);
        log.info("Credenciales actualizadas.");
    }


    /**
     * Destruye el contexto de Spring de la librería Moodle.
     * Debe ser llamado al finalizar la aplicación cliente para liberar recursos.
     */
    public static void destroy() {
        if (context != null) {
            log.info("Destruyendo contexto de Spring...");
            context.close();
            context = null;
        }
    }

    /**
     * Obtiene un Bean de Spring gestionado por la librería Moodle.
     * @param beanClass La clase del bean que se desea obtener.
     * @return La instancia del bean.
     * @throws IllegalStateException si la librería no ha sido inicializada.
     */
    public static <T> T getBean(Class<T> beanClass) {
        if (context == null) {
            throw new IllegalStateException("El contexto de la librería Moodle no ha sido inicializado. Por favor, llama a Moodle.init() al inicio de tu aplicación.");
        }
        return context.getBean(beanClass);
    }
}
