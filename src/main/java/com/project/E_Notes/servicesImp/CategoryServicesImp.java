package com.project.E_Notes.servicesImp;

import com.project.E_Notes.dto.CategoryResponse;
import com.project.E_Notes.dto.Categorydto;
import com.project.E_Notes.entety.Category;
import com.project.E_Notes.repo.CategoryRepo;
import com.project.E_Notes.services.CategoryServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    // THIS CLASS PURPOSE TO MAP DEFFRENT MODEL EASYLY.
    @Autowired
    private ModelMapper mapper;


    @Override
    public Boolean saveCategory(Categorydto categorydto) {
        // Set default values and save category
//        category.setIsDeleted(false);
//        category.setCreatedBy(1);
//        category.setCreatedDate(new Date());
//
//        Category category1 = categoryRepo.save(category);
//
//        // Check if the category was saved successfully
//        return !ObjectUtils.isEmpty(category1);


           // DTO // now all this set using crated object but Know use the Mapper class for easy.

//        Category category = new Category();
//        category.setId(categorydto.getId());
//        category.setName(categorydto.getName());
//        category.setDescription(categorydto.getDescription());
//        category.setIsActive(categorydto.getIsActive());

         // KNOW USE MAPPER CLASS FOR PROFESSIONAL OBJECT OF MAPPING WITH DTO
// note - field name in both model is needed same.
        Category category = mapper.map(categorydto, Category.class);
        category.setIsDeleted(false);
        category.setCreatedBy(1);
        category.setCreatedDate(new Date());
        Category saveCategory = categoryRepo.save(category);
        if (ObjectUtils.isEmpty(saveCategory)){
            return false;
        }
        return  true;
    }

    @Override
    public List<Categorydto> getAllCate() {
       List<Category> categories = categoryRepo.findAll();
       // USE THE DTO OBJECT WITH STREAM API.//we never expose main entity/model in industry level
      List<Categorydto>  categorydto = categories.stream().map(category ->
              mapper.map(category, Categorydto.class)).toList();

       return  categorydto;
    }


    @Override
    public List<CategoryResponse> getallActiveCategory() {
        // in there first get data from category with custom method of repo.
        List<Category> categories = categoryRepo.findByIsActiveTrue();

List<CategoryResponse> categoryResponses = categories.stream()
        .map(category -> mapper.map(category, CategoryResponse.class)).toList();
        return categoryResponses;
    }
}
