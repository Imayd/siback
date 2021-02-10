package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Absence;
import com.ensa.repositories.AbsenceRepo;

@Service
public class AbsenceService implements IAbsenceService{

	@Autowired
	private AbsenceRepo absenceRepo;
	
	@Override
	public Absence addAbsence(Absence absence) throws Exception {
		Absence abs = this.absenceRepo.save(absence);
        return abs;
	}

	@Override
	public Absence updateAbsence(Long id, Absence absence) throws Exception {
		 if (id == null)
	            throw new Exception("Id est null");
	        absence.setId(id);
	        Absence abs = this.absenceRepo.save(absence);
	        return abs;
	}

	@Override
	public List<Absence> findAbsenceByIdModule(Long module) throws Exception {
		if (module == null)
            throw new Exception("Id est null");
        List<Absence> abs = this.absenceRepo.findAbsenceByIdModule(module);
        return abs;
	}

	@Override
	public Long getNbrTotaleAbsenceParModule(Long idModule, Long idEtudiant) throws Exception {
		 if (idModule == null || idEtudiant == null)
	            throw new Exception("Id est null");
	        Long nbrAbsenceByEtudiat = this.absenceRepo.nombreAbsence(idModule, idEtudiant);
	        return nbrAbsenceByEtudiat;
	}

	
}
