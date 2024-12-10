package com.project.E_Notes.services;

import com.project.E_Notes.entety.Category;

import java.util.List;

public interface CategoryServices {
    Boolean saveCategory(Category category);
    List<Category> getAllCate();
}
