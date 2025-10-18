package org.moodle.api.client.moodle_rest_client.domain.exceptions;

public class MoodleApiException extends RuntimeException {
    public MoodleApiException(String message) {
        super(message);
    }

    public MoodleApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
