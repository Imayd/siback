package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.dto.CoursDTO;
import com.ensa.entities.Cours;
import com.ensa.entities.ElementModule;
import com.ensa.repositories.CoursRepo;
import com.ensa.repositories.ElementModuleRepo;

@Service
public class CoursService implements ICoursService{
	
	@Autowired
	CoursRepo coursRepo;
	
	@Autowired
	ElementModuleRepo elementModuleRepo;

	@Override
	public Cours addCours(CoursDTO c) {
		
		Cours cours = new Cours();
		cours.setLabel(c.getLibelle());
		cours.setMot_clé(c.getMotCle());
		//ElementModule elementModule = elementModuleRepo.findById(c.getIdElementModule()).get();
		ElementModule elementModule = elementModuleRepo.findByLibelle(c.getElementModule());
		cours.setElementModule(elementModule);
		System.out.println(cours);
		Cours cc = coursRepo.save(cours);
		return cc;
	}

	@Override
	public Cours updateCours(Long id, Cours c) {

		c.setId(id);
		Cours cc = coursRepo.save(c);
		return cc;
	}

	@Override
	public void deleteCours(Long id) {

		coursRepo.deleteById(id);
	}

	@Override
	public Cours getCours(Long id) {

		return coursRepo.getOne(id);
	}

	@Override
	public List<Cours> getListCours() {

		return coursRepo.findAll();
	}

	@Override
	public List<Cours> findCoursByQuery(String param) {
		List<Cours> cours = this.coursRepo.findCoursByQuery(param);
        return cours;
	}

	@Override
	public List<Cours> getCoursParLabel(String libelle) {

		List<Cours> listCours = this.coursRepo.findByLabel(libelle);
        return listCours;
	}

	@Override
	public Cours findCoursByMotCle(String motCle) {
		Cours cours = this.coursRepo.findCoursByMotCle(motCle);
        return cours;
	}

}
