package com.project.E_Notes.entety;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)// this is for the auditing
public class Category extends BaseModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Boolean isActive;
    private Boolean isDeleted;

}
