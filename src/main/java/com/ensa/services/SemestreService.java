package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.dto.SemestreDTO;
import com.ensa.entities.Niveau;
import com.ensa.entities.Semestre;
import com.ensa.repositories.NiveauRepo;
import com.ensa.repositories.SemestreRepo;

@Service
public class SemestreService {

	@Autowired
	private SemestreRepo semestreRepository;
	@Autowired
    private NiveauRepo niveauRepository;

    public Semestre addSemestre(SemestreDTO dtoInsert) throws Exception {
        if (dtoInsert.getSemestre() == null)
            throw new Exception("Semestre est obligatoire");
        Semestre semestre = new Semestre();
        Niveau niveau = this.niveauRepository.findById(dtoInsert.getNiveau()).get();
        semestre.setSemestre(dtoInsert.getSemestre());
        semestre.setNiveau(niveau);
        return this.semestreRepository.save(semestre);
    }

    public Semestre getSemestre(Long id) throws Exception {
        if (id == null)
            throw new Exception("Id est obligatoire");
        return this.semestreRepository.findById(id).orElseThrow(() -> new Exception("Semestre not found"));
    }

    public List<Semestre> getSemestres() {
        return this.semestreRepository.findAll();
    }

    public List<Semestre> getSemestresNiveau(Long id)throws Exception {
        if (id == null)
        throw new Exception("Id est obligatoire");
        return this.semestreRepository.getSemestreOfNiveau(id);
    }
}
