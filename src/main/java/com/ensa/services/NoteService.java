package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Note;
import com.ensa.repositories.NoteRepo;

@Service
public class NoteService implements INoteService {

	@Autowired
	private NoteRepo noteRepo;
	
	@Override
	public Note addNote(Note note) throws Exception {

		return noteRepo.save(note);
	}

	@Override
	public Note updateNote(Long id, Note note) throws Exception {
		if (id == null)
			throw new Exception("id de note est obligatoire");
		note.setId(id);
		return noteRepo.save(note);
	}

	@Override
	public Note getNoteByIdModule(Long idModule) throws Exception {
		if (idModule == null)
            throw new Exception("id du module est obligatoire");
        Note note = noteRepo.getNoteByIdElement(idModule);
        if (note == null)
            throw new Exception(" Note module not found");
        return note;
	}

	@Override
	public List<Note> getNotesOfEtudiant(Long idEtudiant) throws Exception {
		if (idEtudiant == null)
            throw new Exception("id de l'etudiant est obligatoire");
        List<Note> notes = this.noteRepo.findNotesByEtudiant(idEtudiant);
        return notes;
	}

}
