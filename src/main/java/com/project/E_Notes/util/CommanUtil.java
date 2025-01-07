package com.project.E_Notes.util;
// this class have method help to fill the data on GenericResponce.class Field.also Use

import com.project.E_Notes.categoryHandler.GenericResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommanUtil {

    // take -> put in fild -> same time return using method.

    // if success.
    public static ResponseEntity<?> createBuildResponces(Object data, HttpStatus status){
        // object of genericResponce.class
        GenericResponce responce = GenericResponce.builder()
                .responseStatus(status).status("success").massage("Success").data(data)
                .build();
        return responce.create();
    }

    //Another with if have massage. with success
    public static ResponseEntity<?> crateBuildResponceMassage(String massage, HttpStatus status){
        // object of genericResponce.class
        GenericResponce responce = GenericResponce.builder()
                .responseStatus(status).status("success").massage(massage)
                .build();
        return responce.create();
    }
    //Another with if have Error.
    public static ResponseEntity<?> crateErrorResponce(Object data, HttpStatus status){
        // object of genericResponce.class
        GenericResponce responce = GenericResponce.builder()
                .responseStatus(status).status("failed").massage("failed")
                .data(data)
                .build();
        return responce.create();
    }

    //Another with if have Error and massage.
    public static ResponseEntity<?> crateErrorResponSeMassage(String massage, HttpStatus status){
        // object of genericResponce.class
        GenericResponce responce = GenericResponce.builder()
                .responseStatus(status).status("failed").massage(massage)
                .build();
        return responce.create();
    }
}
