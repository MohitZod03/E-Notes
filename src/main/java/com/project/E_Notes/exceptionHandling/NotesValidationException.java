package com.project.E_Notes.exceptionHandling;

import java.util.Map;

public class NotesValidationException extends RuntimeException {

    private Map<String, Object> error;

    public NotesValidationException(Map<String, Object> error) {
        super("Notes Validation Failed");
        this.error = error;
    }

    public Map<String, Object> getError() {
        return error;
    }
}
