
// IN COMPANY ACTUAL WORK IS DOING LIKE THIS DTO(DATA TRANSFER OBJECT).


package com.project.E_Notes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categorydto {
    private Integer id;
    private String name;
    private String description;
    private Boolean isActive;
    private Integer createdBy;
    private Date createdDate;
    private Integer updatedId;
    private Date updatedDate;

}
