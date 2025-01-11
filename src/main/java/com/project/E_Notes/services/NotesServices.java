package com.project.E_Notes.services;

import com.project.E_Notes.dto.NotesDto;
import com.project.E_Notes.entety.Notes;

import java.util.List;

public interface NotesServices {

    Boolean saveNotes(NotesDto notesDto) throws Exception;

    List<NotesDto> getAllNotes();

}
