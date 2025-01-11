package com.project.E_Notes.controller;

import com.project.E_Notes.dto.NotesDto;
import com.project.E_Notes.services.NotesServices;
import com.project.E_Notes.util.CommanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NotesController {

    @Autowired
    private NotesServices notesService;

    @PostMapping("/")
    public ResponseEntity<?> saveNotes(@RequestBody NotesDto notesDto) throws Exception {
        Boolean saveNotes = notesService.saveNotes(notesDto);
        if (saveNotes) {
            return CommanUtil.crateBuildResponceMassage("Notes saved success", HttpStatus.CREATED);
        }
        return CommanUtil.crateErrorResponSeMassage("Notes not saved", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllNotes() {
        List<NotesDto> notes = notesService.getAllNotes();
        if (CollectionUtils.isEmpty(notes)) {
            return ResponseEntity.noContent().build();
        }
        return CommanUtil.createBuildResponces(notes, HttpStatus.OK);
    }
}
