package com.project.E_Notes.services;

import com.project.E_Notes.dto.CategoryResponse;
import com.project.E_Notes.dto.Categorydto;
import com.project.E_Notes.entety.Category;
import com.project.E_Notes.exceptionHandling.ResourcesNotFoundException;

import java.util.List;

public interface CategoryServices {
    Boolean saveCategory(Categorydto categorydto);
    List<Categorydto> getAllCate();


    // this is  from category response object of active category.
    List<CategoryResponse> getallActiveCategory();


    // find the category by id
    public Categorydto getCategoryById(Integer id) throws ResourcesNotFoundException;

    // Deleted Category
    public boolean deletCategory(Integer id);
}
