package com.project.E_Notes.exceptionHandling;


import com.project.E_Notes.util.CommanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j // this is for the log when this field is executed

@ControllerAdvice // this is applied every api in aby package.
public class GlobalExceptionHandler {

    // global exception  // if any kind of exception occur.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e){
       // return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return CommanUtil.crateErrorResponSeMassage(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);// same Generic Response
    }


    // crated exception handler. if null point in any
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointException(Exception e){
       // return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return CommanUtil.crateErrorResponSeMassage(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);// same Generic Response
    }

    // Resources not found exception handing but through own class passing.
    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<?> resourcesNotFoundException(Exception e){
        log.error("GlobalExceptionHandler :: handlerNotFoundException::",e.getMessage());
      //  return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return CommanUtil.crateErrorResponSeMassage(e.getMessage(),HttpStatus.NOT_FOUND);// same Generic Response
    }


//    @ExceptionHandler(ValidationException.class)
//    public ResponseEntity<?> validationException(ValidationException e){
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }



    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException e) {
        // Prepare response with error details
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("message", e.getMessage()); // Generic "Validation Failed"
        response.put("errors", e.getError());   // Detailed field errors
      //  return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return CommanUtil.crateErrorResponce(response,HttpStatus.BAD_REQUEST);
    }

// to handle Exist name in category already .
    @ExceptionHandler(ExistDataException.class)
    public ResponseEntity<?> handleExistDataException(ExistDataException e) {
      //  return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        return CommanUtil.crateErrorResponSeMassage(e.getMessage(),HttpStatus.CONFLICT);
    }
// if pass wrong isActive
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        //return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        return CommanUtil.crateErrorResponSeMassage(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
