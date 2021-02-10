package com.ensa.services;

import java.util.List;

import com.ensa.dto.NiveauDTO;
import com.ensa.entities.Niveau;

public interface INiveauService {

	public Niveau addNiveau(NiveauDTO niveau) throws Exception;
	public List<Niveau> getAllNiveaux();
	public void deleteNiveau(Long id) throws Exception;
}
