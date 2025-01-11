package com.project.E_Notes.repo;

import com.project.E_Notes.entety.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface NotesRepo extends JpaRepository<Notes,Integer> {

}
