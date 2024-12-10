package com.project.E_Notes.entety;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseCategory {

    private Boolean isActive;

    private Boolean isDeleted;
    private Integer createdBy;
    private Date createdDate;
    private Integer updatedId;
    private Date updatedDate;
}
