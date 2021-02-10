package com.ensa.services;

import java.util.List;

import com.ensa.entities.Note;

public interface INoteService {

	public Note addNote(Note note) throws Exception;

	public Note updateNote(Long id, Note note) throws Exception;

	public Note getNoteByIdModule(Long idModule) throws Exception;

	public List<Note> getNotesOfEtudiant(Long idEtudiant) throws Exception;
}
