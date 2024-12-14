package com.project.E_Notes.exceptionHandling;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j // this is for the log when this field is executed

@ControllerAdvice // this is applied every api in aby package.
public class GlobalExceptionHandler {

    // global exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // crated exception handler. if null point in any
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Resources not found exception handing but through own class passing.
    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<?> resourcesNotFoundException(Exception e){
        log.error("GlobalExceptionHandler :: handlerNotFoundException::",e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }


}
