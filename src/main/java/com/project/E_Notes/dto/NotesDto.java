package com.project.E_Notes.dto;

import com.project.E_Notes.entety.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

// This is for the Dto object or Copy of notes.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotesDto {
    private Integer id;

    private String title;

    private String description;

   private Categorydto category;

    private Integer createdBy;

    private Date createdOn;

    private Integer updatedBy;

    private Date updatedOn;


// Use Nested Class Because we want  only Show id, Name of Category.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public static class Categorydto{

        private Integer id;
        private String name;

    }


}
