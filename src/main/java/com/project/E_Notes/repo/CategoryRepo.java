package com.project.E_Notes.repo;

import com.project.E_Notes.entety.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
    // custom method for find with active category.
    List<Category> findByIsActiveTrue();
}
