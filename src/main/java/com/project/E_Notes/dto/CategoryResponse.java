package com.project.E_Notes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

// THIS IS CLASS SAME WORK LIKE DTO NOT GET  DIRECT RESPONSE FROM CATEGORY.
 // ALSO  WANT SOME FEW OF ALL FIELD WANT TO SHOW THAT TIME ALSO HELP
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private Integer id;
    private String name;
    private String description;
    private Integer createdBy;
    private Date createdDate;

}
