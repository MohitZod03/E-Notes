package com.project.E_Notes.repo;

import com.project.E_Notes.entety.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
    // custom  method that already present in JPA.  for find with active category.
    List<Category> findByIsActiveTrueAndIsDeletedFalse();


    // THIS IS FIND CATEGORY BY ID IF DELETE IS FALSE METHOD. this is also present in jpa.
    Optional<Category> findByIdAndIsDeletedFalse(Integer id);

    // it is also present in jpa with some modification.
    List<Category> findByIsDeletedFalse();

    Boolean existsByName(String name);
}
