package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Etudiant;
import com.ensa.repositories.EtudiantRepo;

@Service
public class EtudiantService implements IEtudiantService {
	
	@Autowired
	private EtudiantRepo etudiantRepo;
	
	public Etudiant addEtudiant(Etudiant e) {
		
		Etudiant etud = etudiantRepo.save(e);
		
		return etud;
	}

	@Override
	public Etudiant updateEtudiant(Long id,Etudiant e) {
		 e.setId(id);
	     Etudiant newEtudiant = this.etudiantRepo.save(e);
	     return newEtudiant;
	}

	@Override
	public void deleteEtudiant(Long id) {
		etudiantRepo.deleteById(id);
	}

	@Override
	public Etudiant getEtudiant(Long id) {
		return etudiantRepo.getOne(id);
	}
	
	

	@Override
	public List<Etudiant> getAllEtudiants() {

		return etudiantRepo.findAll();
	}

}
