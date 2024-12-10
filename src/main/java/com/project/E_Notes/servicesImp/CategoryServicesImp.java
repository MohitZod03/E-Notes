package com.project.E_Notes.servicesImp;

import com.project.E_Notes.entety.Category;
import com.project.E_Notes.repo.CategoryRepo;
import com.project.E_Notes.services.CategoryServices;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;


@Service
public class CategoryServicesImp implements CategoryServices {

    private final CategoryRepo categoryRepo;

    // Constructor-based Dependency Injection
    public CategoryServicesImp(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Boolean saveCategory(Category category) {
        // Set default values and save category
        category.setIsDeleted(false);
        category.setCreatedBy(1);
        category.setCreatedDate(new Date());

        Category category1 = categoryRepo.save(category);

        // Check if the category was saved successfully
        return !ObjectUtils.isEmpty(category1);
    }

    @Override
    public List<Category> getAllCate() {
        return categoryRepo.findAll();
    }
}
