package com.project.E_Notes.exceptionHandling;

import java.util.Map;

public class ValidationException extends RuntimeException
{

    // create map object with key and value
    Map<String, Object > error;

    public ValidationException(Map<String,Object> error)
    {
        super("Validation Failed");
        this.error =error;

    }

    public Map<String, Object> getError()
    {
        return error;
    }


}
