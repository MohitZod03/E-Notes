package com.project.E_Notes.categoryHandler;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

import java.util.LinkedHashMap;
import java.util.Map;

//   This is class Purpose Get Proper or Structural Response After any Operation

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericResponce {

    private HttpStatus responseStatus; // status code ex-200,420

    private String status; // success/ Failed.

    private String massage; // passing massage.

    private Object data;// data

    // Created Class that Store from field and the Show responses.
    public ResponseEntity<?> create()
    {
        // created the map for store responses and send.
        Map<String ,Object > map =new LinkedHashMap<>();
        map.put("status",status);
        map.put("massage",massage);
        // if have data then store
        if (!ObjectUtils.isEmpty(data))// not empty.
        {
            map.put("data",data);
        }
        return new ResponseEntity<>(map,responseStatus);

    }
}
