package com.ensa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Enseignant;
import com.ensa.repositories.EnseignantRepo;

@Service
public class EnseignantService {

	@Autowired
	 private EnseignantRepo profRepository;
	    
	public Enseignant addProf(Enseignant prof) throws Exception {
        
        Enseignant savedProf = this.profRepository.save(prof);
        return savedProf;
    }

    public Enseignant updateProf(Long id, Enseignant prof) throws Exception {
        prof.setId(id);
        Enseignant savedProf = this.profRepository.save(prof);
        return savedProf;
    }
}
