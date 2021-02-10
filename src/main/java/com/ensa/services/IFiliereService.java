package com.ensa.services;

import java.util.List;

import com.ensa.entities.Filiere;

public interface IFiliereService {

	public Filiere addFiliere(Filiere filiere) throws Exception;

    public Filiere updateFiliere(Long id, Filiere filiere);

    public Filiere getFiliere(Long id) throws Exception;

    public List<Filiere> getFilieres() throws Exception;

    public void deleteFiliere(Long id) throws Exception;
}
