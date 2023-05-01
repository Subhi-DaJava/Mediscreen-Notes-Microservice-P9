package com.oc.practitionernotes.service;

import com.oc.practitionernotes.model.Note;

import java.time.LocalDateTime;
import java.util.List;

public interface NoteService {
    List<Note> getPatientAllNotesByPatientId(Long id);
    List<Note> getPatientAllNotesByPatientLastName(String lastName);

    Note saveNote(Note note);

    Note updateNoteById(String id, Note note);


    void deleteById(String id);
}
