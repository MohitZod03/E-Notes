package com.project.E_Notes.servicesImp;

import com.project.E_Notes.dto.CategoryResponse;
import com.project.E_Notes.dto.Categorydto;
import com.project.E_Notes.entety.Category;
import com.project.E_Notes.exceptionHandling.ExistDataException;
import com.project.E_Notes.exceptionHandling.ResourcesNotFoundException;
import com.project.E_Notes.repo.CategoryRepo;
import com.project.E_Notes.services.CategoryServices;
import com.project.E_Notes.util.Validation;
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

    @Autowired
    private Validation validation;

                  // SAVE-CATEGORY(get value from dto and pass value in category.)

    @Override
    public Boolean saveCategory(Categorydto categorydto) {

            // Validation checker before post
        validation.categoryValidation(categorydto);

        // check the exist category with same name if then proper exception.
        Boolean exist= categoryRepo.existsByName(categorydto.getName());
         if(exist)// if true or the category with same name exist
         {
                throw new ExistDataException("Category with name already exist ");
         }


        Category category = mapper.map(categorydto, Category.class);

        // apply same with updated this category the & save .
        // if not present already then save otherwise updated.
        if (ObjectUtils.isEmpty(category.getId())){
            category.setIsDeleted(false);
//            category.setCreatedBy(1);
//            category.setCreatedDate(new Date());
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

// transfer  data from db dto responce object with help of category obj in CategoryRespon obj.

List<CategoryResponse> categoryResponses = categories.stream()
        .map(category -> mapper.map(category, CategoryResponse.class)).toList();
        return categoryResponses;
    }


                           // GET-CATEGORY-BY-ID

    // this is to find category from db with id then pass data to dto object for showing.

    @Override
    public Categorydto getCategoryById(Integer id) throws ResourcesNotFoundException {
        // use here to find from option in categories with help of id also handle exception.

        Category category = categoryRepo.findByIdAndIsDeletedFalse(id)
                .orElseThrow(()-> new ResourcesNotFoundException("Category not found with this id = "+id));
        // apply condition id if id found then.
        if (!ObjectUtils.isEmpty(category)){

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

//            category.setUpdatedId(1);
//            category.setUpdatedDate(new Date());


        }
    }


}
