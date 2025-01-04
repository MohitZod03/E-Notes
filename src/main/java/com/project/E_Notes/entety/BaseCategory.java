package com.project.E_Notes.entety;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.Update;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseCategory { // compalcery to geive body.

    @CreatedBy
    @Column(updatable = false)// by default true
    private Integer createdBy;

    @CreatedDate  // this field automatically fill for tracking purpose.
    @Column(updatable = false)
    private Date createdDate;

    @LastModifiedBy
    @Column(insertable = false)
    private Integer updatedId;

    @LastModifiedDate
    @Column(insertable = false)
    private Date updatedDate;
}
