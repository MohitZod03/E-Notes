package com.project.E_Notes.util;


import com.project.E_Notes.dto.Categorydto;
import com.project.E_Notes.exceptionHandling.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class Validation
{

    public void categoryValidation(Categorydto categorydto)
    {

        // created the mapping object for show error.
        Map<String,Object> error = new LinkedHashMap<>();

        // if pass the black or empty category then validate.
        if (ObjectUtils.isEmpty(categorydto))
        {
            throw new IllegalArgumentException("Category Object should me null or empty");
        }
        else
        {

// if name field is empty or null and length of name field.

            if (ObjectUtils.isEmpty(categorydto.getName()))
            {
                error.put("name","name field is empty or null");
            }else
            {
                if (categorydto.getName().length()<5)
                {
                    error.put("name","name length min 5");
                }if (categorydto.getName().length()>100)
            {
                error.put("name","name length max 100");
            }
            }
// Validation of the Description.

            if (ObjectUtils.isEmpty(categorydto.getDescription()))
            {

                error.put("description","description field is empty or null");
            }

// validation for the isActive field.
            if (ObjectUtils.isEmpty(categorydto.getIsActive()))
            {
                error.put("isActive","isActive field is empty or null");
            }else
            {

                if(categorydto.getIsActive()!= Boolean.TRUE.booleanValue()
                        && categorydto.getIsActive()!=Boolean.FALSE.booleanValue()){
                    error.put("isActive","invalid value in isActive field");
                }

            }


        }

        if (!error.isEmpty())
        {
            throw new ValidationException(error);
        }


    }



}
