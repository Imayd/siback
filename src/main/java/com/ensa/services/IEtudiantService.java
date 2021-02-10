package com.ensa.services;

import java.util.List;

import com.ensa.entities.Etudiant;

public interface IEtudiantService {

	public Etudiant addEtudiant(Etudiant e);
	public Etudiant updateEtudiant(Long id,Etudiant e);
	public void deleteEtudiant(Long id);
	public Etudiant	getEtudiant(Long id);
	public List<Etudiant> getAllEtudiants();

	
}
