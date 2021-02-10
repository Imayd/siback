package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Filiere;
import com.ensa.repositories.FiliereRepo;

@Service
public class FiliereService implements IFiliereService {

	@Autowired
	private FiliereRepo filiereRepo;
	
	@Override
	public Filiere addFiliere(Filiere filiere) throws Exception {
		if (filiere.getNomFormation() == null) {
            throw new Exception("Description est obligatoire");
        }
        Filiere savedFiliere = this.filiereRepo.save(filiere);
        return savedFiliere;
	}

	@Override
	public Filiere updateFiliere(Long id, Filiere filiere) {
		filiere.setId(id);
        Filiere filiere2 = this.filiereRepo.save(filiere);
        return filiere2;
	}

	@Override
	public Filiere getFiliere(Long id) throws Exception {
		if (id == null) {
            throw new Exception("id est obligatoire");
        }
        Filiere savedFiliere = this.filiereRepo.findById(id)
                .orElseThrow(() -> new Exception("Filiere not Found"));
        return savedFiliere;
	}

	@Override
	public List<Filiere> getFilieres() throws Exception {
		List<Filiere> listFiliere = this.filiereRepo.findAll();
        return listFiliere;
	}

	@Override
	public void deleteFiliere(Long id) throws Exception {
		if (id == null) {
            throw new Exception("id est obligatoire");
        }
        this.filiereRepo.deleteById(id);
		
	}

}
