package com.ensa.services;

import java.util.List;

import com.ensa.entities.Absence;

public interface IAbsenceService {


    public Absence addAbsence(Absence absence) throws Exception;

    public Absence updateAbsence(Long id, Absence absence) throws Exception;

    public List<Absence> findAbsenceByIdModule(Long module) throws Exception;

    public Long getNbrTotaleAbsenceParModule(Long idModule, Long idEtudiant) throws Exception;
}
