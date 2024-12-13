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
import java.util.Optional;


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

                  // SAVE-CATEGORY(get value from dto and pass value in category.)

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
// note - field name in both model is needed same. automatically get value in category.



        Category category = mapper.map(categorydto, Category.class);

        // apply same with updated this category the & save .
        // if not present already then save otherwise updated.
        if (ObjectUtils.isEmpty(category.getId())){
            category.setIsDeleted(false);
            category.setCreatedBy(1);
            category.setCreatedDate(new Date());
        }else {
            // this is for the updated if already exist.
            updatedCategory(category);
        }


        Category saveCategory = categoryRepo.save(category);
        if (ObjectUtils.isEmpty(saveCategory)){
            return false;
        }
        return  true;
    }

              // To get all categories if the isDeleted false.

    @Override
    public List<Categorydto> getAllCate() {
       List<Category> categories = categoryRepo.findByIsDeletedFalse();
       // USE THE DTO OBJECT WITH STREAM API.//we never expose main entity/model in industry level
      List<Categorydto>  categorydto = categories.stream().map(category ->
              mapper.map(category, Categorydto.class)).toList();

       return  categorydto;
    }

                            // FIND ACTIVE-CATEGORY

    @Override
    public List<CategoryResponse> getallActiveCategory() {
        // in there first get data from category with custom method of repo.
        List<Category> categories = categoryRepo.findByIsActiveTrueAndIsDeletedFalse();

List<CategoryResponse> categoryResponses = categories.stream()
        .map(category -> mapper.map(category, CategoryResponse.class)).toList();
        return categoryResponses;
    }


                           // GET-CATEGORY-BY-ID

    // this is to find category from db with id then pass data to dto object for showing.
    @Override
    public Categorydto getCategoryById(Integer id) {
        // use here to find from option in categories with help of id

        Optional<Category> findCategoryByID = categoryRepo.findByIdAndIsDeletedFalse(id);
        // apply condition id if id found then.
        if (findCategoryByID.isPresent()){
            Category category = findCategoryByID.get();
            // it is map data for view  from category to CategoryDto
            return mapper.map(category, Categorydto.class);

        }return null;
    }


                          // DELETE-CATEGORY

    // WE FIND ID THEN TRUE THE isDeleted. NOT SHOW TO USER THEN.

    @Override
    public boolean deletCategory(Integer id) {

        Optional<Category> findCategoryByID = categoryRepo.findById(id);
        // apply condition id if id found then.
        if (findCategoryByID.isPresent())
        {
            Category category = findCategoryByID.get();
            // SET TRUE isDelete if find id.
            category.setIsDeleted(true);
            // save this
            categoryRepo.save(category);
            return true;
        }
        return false;

    }

// write the code for the update the category.
         //NOTE - save and update in one api. write "id"=value  needed.

    public void updatedCategory(Category category){
// first we find the category with help of id
        Optional<Category> findById = categoryRepo.findById(category.getId());
        // then create object of category some things set from backend.

        if (findById.isPresent()){
            // this object get value from db with help of id.

            Category existCategory = findById.get();
            category.setIsDeleted(existCategory.getIsDeleted());
            category.setCreatedDate(existCategory.getCreatedDate());
            category.setCreatedBy(existCategory.getCreatedBy());

            category.setUpdatedId(1);
            category.setUpdatedDate(new Date());


        }
    }


}
