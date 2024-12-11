package com.project.E_Notes.controller;

import com.project.E_Notes.dto.CategoryResponse;
import com.project.E_Notes.dto.Categorydto;
import com.project.E_Notes.entety.Category;
import com.project.E_Notes.services.CategoryServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorys")
public class CategoryController {

    private final CategoryServices categoryServices;

    // Constructor-based Dependency Injection
    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    // To save category
    @PostMapping("/save-category")
    public ResponseEntity<?> saveCategory(@RequestBody Categorydto categorydto) {
        Boolean saveCategory = categoryServices.saveCategory(categorydto);

        // Condition to check if the category was saved successfully
        if (saveCategory) {
            return new ResponseEntity<>("Category saved successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Category not saved", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // To get all categories
    @GetMapping("/category")
    public ResponseEntity<?> getAllCategory() {
        List<Categorydto> categories = categoryServices.getAllCate();

        // Using Spring's CollectionUtils to check for an empty list
        if (CollectionUtils.isEmpty(categories)) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
    }


// this is for get only if is active with minimum field from CategoryResponse.

    @GetMapping("/active-category")
    public ResponseEntity<?> getAllActiveCategory() {
        List<CategoryResponse> categories = categoryServices.getallActiveCategory();

        // Using Spring's CollectionUtils to check for an empty list
        if (CollectionUtils.isEmpty(categories)) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
    }
}
