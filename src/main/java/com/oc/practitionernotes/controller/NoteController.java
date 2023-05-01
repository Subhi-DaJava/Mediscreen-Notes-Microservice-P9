package com.oc.practitionernotes.controller;

import com.oc.practitionernotes.model.Note;
import com.oc.practitionernotes.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final static Logger logger = LoggerFactory.getLogger(NoteController.class);
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/by-patId/{patId}")
    public ResponseEntity<List<Note>> getAllNotesOfPatientPatId(@PathVariable Long patId) {
        logger.debug("getAllNotesOfPatientByPatId starts here, from NoteController");
        List<Note> notes =  noteService.getPatientAllNotesByPatientId(patId);
        logger.info("All Notes of this patient with patId:{%d} have been retrieved from DB!".formatted(patId));
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/by-lastName/{lastName}")
    public ResponseEntity<List<Note>> getAllNotesOfPatientPatLastName(@PathVariable String lastName) {
        logger.debug("getAllNotesOfPatientByPatLastName starts here, from NoteController");
        List<Note> notes =  noteService.getPatientAllNotesByPatientLastName(lastName);
        logger.info("All Notes of this patient with patLastName:{%s} have been retrieved from DB!".formatted(lastName));
        return ResponseEntity.ok(notes);
    }

    @PostMapping("/")
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        logger.debug("addNote starts here, from NoteController");
        Note noteSaved = noteService.saveNote(new Note(note.getPatId(), note.getPatLastName(), note.getComment()));
        logger.info("New note with pathPatId:{} and lastName:{} has been successfully saved, from NoteController", note.getPatId(), note.getPatLastName());
        return new ResponseEntity<>(noteSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateById(@PathVariable String id, @RequestBody Note note) {
        logger.debug("updateById starts here, from NoteController");
        Note noteUpdated = noteService.updateNoteById(id, note);
        logger.info("Note with id:{} has been successfully updated, from NoteController", id);
        return ResponseEntity.ok(noteUpdated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable String id) {
        logger.debug("deleteById starts here, from NoteController");
        try {
            noteService.deleteById(id);
            logger.info("Note with id:{} has been successfully deleted from NoteController", id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Note with id:{} not found DB from NoteController", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
