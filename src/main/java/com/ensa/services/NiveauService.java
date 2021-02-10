package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.dto.NiveauDTO;
import com.ensa.entities.Filiere;
import com.ensa.entities.Niveau;
import com.ensa.repositories.NiveauRepo;

@Service
public class NiveauService implements INiveauService {

	@Autowired
	private NiveauRepo niveauRepo;
	@Autowired
    private FiliereService filiereService;
	
	@Override
	public Niveau addNiveau(NiveauDTO niveau) throws Exception {
		if (niveau.getNiveau() == null)
            throw new Exception("Le champ niveau est obligatoir");

        Filiere flr = this.filiereService.getFiliere(niveau.getFiliere());
        Niveau nv = new Niveau();
        nv.setNiveau(niveau.getNiveau());
        nv.setFiliere(flr);
        Niveau niveau2 = this.niveauRepo.save(nv);
        return niveau2;
	}

	@Override
	public List<Niveau> getAllNiveaux() {
		List<Niveau> niveaus = this.niveauRepo.findAll();
        return niveaus;
	}

	@Override
	public void deleteNiveau(Long id) throws Exception {
		if (id == null) {
            throw new Exception("id est obligatoir");
        }
        this.niveauRepo.deleteById(id);
	}

}
