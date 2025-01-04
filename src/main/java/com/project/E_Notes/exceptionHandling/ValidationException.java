package com.project.E_Notes.exceptionHandling;

import java.util.Map;

public class ValidationException extends RuntimeException {
    private final Map<String, Object> error;

    public ValidationException(Map<String, Object> error) {
        super("Validation Failed"); // Generic message
        this.error = error;         // Detailed errors
    }

    public Map<String, Object> getError() {
        return error;
    }
}
