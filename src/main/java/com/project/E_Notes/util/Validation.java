package com.project.E_Notes.util;


import com.project.E_Notes.dto.Categorydto;
import com.project.E_Notes.dto.NotesDto;
import com.project.E_Notes.exceptionHandling.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class Validation {

    public void categoryValidation(Categorydto categorydto) {
        // Map to collect all validation errors
        Map<String, Object> error = new LinkedHashMap<>();

        // Check if the DTO itself is null
        if (ObjectUtils.isEmpty(categorydto)) {
            throw new IllegalArgumentException("Category object cannot be null or empty");
        }

        // Validate the 'name' field
        if (ObjectUtils.isEmpty(categorydto.getName())) {
            error.put("name", "Name field is empty or null");
        } else {
            if (categorydto.getName().length() < 5) {
                error.put("name", "Name length must be at least 5 characters");
            }
            if (categorydto.getName().length() > 100) {
                error.put("name", "Name length must not exceed 100 characters");
            }
        }

        // Validate the 'description' field
        if (ObjectUtils.isEmpty(categorydto.getDescription())) {
            error.put("description", "Description field is empty or null");
        }

        // Validate the 'isActive' field
        if (ObjectUtils.isEmpty(categorydto.getIsActive())) {
            error.put("isActive", "isActive field is empty or null");
        } else if (categorydto.getIsActive() != Boolean.TRUE && categorydto.getIsActive() != Boolean.FALSE) {
            error.put("isActive", "Invalid value in isActive field; must be true or false");
        }

        // If there are any errors, throw ValidationException
        if (!error.isEmpty()) {
            throw new ValidationException(error);
        }
    }


    // Notes Validation  here.
    public void notesValidation(NotesDto notesDto) {
        // Map to collect all validation errors
        Map<String, Object> error = new LinkedHashMap<>();

        // Check if the DTO itself is null
        if (ObjectUtils.isEmpty(notesDto)) {
            throw new IllegalArgumentException("Notes object cannot be null or empty");
        }

        // Validate the 'name' field
        if (ObjectUtils.isEmpty(notesDto.getTitle())) {
            error.put("Title", "Title field is empty or null");
        } else {
            if (notesDto.getTitle().length() < 5) {
                error.put("Title", "Title length must be at least 5 characters");
            }
            if (notesDto.getTitle().length() > 100) {
                error.put("Title", "Title length must not exceed 100 characters");
            }
        }

        // Validate the 'description' field
        if (ObjectUtils.isEmpty(notesDto.getDescription())) {
            error.put("description", "Description field is empty or null");
        }

        // Validate `categoryId`
        if (ObjectUtils.isEmpty(notesDto.getCategory())) {
            error.put("categoryId", "Category ID is missing");
        }


        // If there are Not Empty errors,then throw ValidationException
        if (!error.isEmpty()) {
            throw new ValidationException(error);
        }
    }


}
