package com.project.E_Notes.servicesImp;

import com.project.E_Notes.dto.NotesDto;
import com.project.E_Notes.entety.Category;
import com.project.E_Notes.entety.Notes;
import com.project.E_Notes.exceptionHandling.ResourcesNotFoundException;
import com.project.E_Notes.repo.CategoryRepo;
import com.project.E_Notes.repo.NotesRepo;
import com.project.E_Notes.services.NotesServices;
import com.project.E_Notes.util.Validation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class NotesServicesImp implements NotesServices {

    // Repo object
    @Autowired
    private NotesRepo notesRepo;

    @Autowired
    private ModelMapper mapper; // mapping of notes and dto.

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private Validation validation;

    @Override
    public Boolean saveNotes(NotesDto notesDto) throws Exception {

        // this is validation on filed
        validation.notesValidation(notesDto);

                // Category Exist Or not Check Validation.
        checkCategoryExist(notesDto.getCategory());

        Notes notes = mapper.map(notesDto, Notes.class);
        Notes saveNotes = notesRepo.save(notes);
        if (!ObjectUtils.isEmpty(saveNotes)) {
            return true;
        }
        return false;
    }
// this is method check category is present or not before created notes
    private void checkCategoryExist(NotesDto.Categorydto category) throws Exception {

        categoryRepo.findById(category.getId()).orElseThrow(()-> new ResourcesNotFoundException("Category Id Pass is Invalid"));
    }



    @Override
    public List<NotesDto> getAllNotes() {
        return notesRepo.findAll().stream().map(note -> mapper.map(note, NotesDto.class)).toList();
    }
}
