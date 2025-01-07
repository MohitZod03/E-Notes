package com.project.E_Notes.controller;

import com.project.E_Notes.dto.CategoryResponse;
import com.project.E_Notes.dto.Categorydto;
import com.project.E_Notes.entety.Category;
import com.project.E_Notes.exceptionHandling.ResourcesNotFoundException;
import com.project.E_Notes.services.CategoryServices;
import com.project.E_Notes.util.CommanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j // this is for the logs in field.
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryServices categoryServices;

    // Constructor-based Dependency Injection
    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    // To save category
    @PostMapping("/save-category")
    // to use response entity then show the status of api.
    public ResponseEntity<?> saveCategory(@RequestBody Categorydto categorydto) {
        Boolean saveCategory = categoryServices.saveCategory(categorydto);

        // Condition to check if the category was saved successfully
        if (saveCategory) {
           // return new ResponseEntity<>("Category saved successfully", HttpStatus.CREATED);
            return CommanUtil.crateBuildResponceMassage("Category saved successfully",HttpStatus.CREATED);
        } else {
           // return new ResponseEntity<>("Category not saved", HttpStatus.INTERNAL_SERVER_ERROR);
            return CommanUtil.crateErrorResponSeMassage("Category not saved",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

                 // to get all the category.

    @GetMapping("/")
    public ResponseEntity<?> getAllCategory() {

        List<Categorydto> categories = categoryServices.getAllCate();

        // Using Spring's CollectionUtils to check for an empty list
        if (CollectionUtils.isEmpty(categories)) {
            return ResponseEntity.noContent().build();
        } else {
            //return new ResponseEntity<>(categories, HttpStatus.OK);
            return CommanUtil.createBuildResponces(categories,HttpStatus.OK);
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
            //return new ResponseEntity<>(categories, HttpStatus.OK);
            return CommanUtil.createBuildResponces(categories,HttpStatus.OK);

        }
    }



    //  THIS TO FIND CATEGORY USING ID.

@GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id) throws Exception{
        // Using this object we fill active all field of object

        Categorydto categorydto = categoryServices.getCategoryById(id);
        //if from the use of services  find data in dto object is empty.
        if (ObjectUtils.isEmpty(categorydto)){
           // return new ResponseEntity<>("Category not found with ID="+ id,HttpStatus.NOT_FOUND);
            return CommanUtil.crateErrorResponSeMassage("Category not found with ID",HttpStatus.NOT_FOUND);
        }
       // return new ResponseEntity<>(categorydto, HttpStatus.OK);
    return CommanUtil.createBuildResponces(categorydto,HttpStatus.OK);

    // first one catch not worked then second catch run.


    }


         // delete the category

   @DeleteMapping("/{id}")
  public ResponseEntity<?>deleteCategory(@PathVariable Integer id) {
      // use object is true.

    boolean deleted = categoryServices.deletCategory(id);
    if (deleted){
       // return new ResponseEntity<>("Category Delete Successfully",HttpStatus.OK);
        return CommanUtil.crateBuildResponceMassage("Category Delete Successfully",HttpStatus.OK);
    }
   // return new ResponseEntity<>("Category Not deleted or Id not found ",HttpStatus.INTERNAL_SERVER_ERROR);
return CommanUtil.crateErrorResponSeMassage("Category Not deleted or Id not found",HttpStatus.INTERNAL_SERVER_ERROR);
}





}
