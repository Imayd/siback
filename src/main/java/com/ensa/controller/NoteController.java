package com.ensa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.Note;
import com.ensa.services.NoteService;

@RestController
@RequestMapping(path = "/api/notes")
public class NoteController {
    
	@Autowired
	private NoteService noteService;

    @GetMapping(path = "/elementmodule/{idModule}")
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ETUDIANT')")
    public Note getNoteByIdElement(@PathVariable("idModule") Long idElem) throws Exception {
        return this.noteService.getNoteByIdModule(idElem);
    }

    @GetMapping(value = "/etudiant/{idEtudiant}")
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ETUDIANT')")
    public List<Note> getNotesByEtudiant(@PathVariable("idEtudiant") Long idEtudiant) throws Exception {
        return this.noteService.getNotesOfEtudiant(idEtudiant);
    }

    @PostMapping(path = "/")
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN')")
    public Note addNote(@RequestBody Note note) throws Exception {
        return this.noteService.addNote(note);
    }

    @PutMapping(path = "/{idNote}")
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN')")
    public Note updateNote(@RequestBody Note note, @PathVariable("id") Long id) throws Exception {
        return this.noteService.updateNote(id, note);
    }
}
