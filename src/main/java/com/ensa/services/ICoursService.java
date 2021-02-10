package com.ensa.services;

import java.util.List;

import com.ensa.dto.CoursDTO;
import com.ensa.entities.Cours;

public interface ICoursService {

	public Cours addCours(CoursDTO c);
	public Cours updateCours(Long id, Cours c);
	public void deleteCours(Long id);
	public Cours getCours(Long id);
	public List<Cours> getListCours();
	public List<Cours> findCoursByQuery(String param);
	public List<Cours> getCoursParLabel(String libelle);
	public Cours findCoursByMotCle(String motCle);
}
