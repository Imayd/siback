package com.ensa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.Etudiant;
import com.ensa.services.EtudiantService;

@RestController
@RequestMapping(path = "/api/users/etudiants")
public class EtudiantController {

	@Autowired
	private EtudiantService etudiantService;
	
	@GetMapping(value = "/")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Etudiant> getEtudiants(){
        return this.etudiantService.getAllEtudiants();
    }
	
	@PostMapping(path = "signup")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Etudiant addEtudiant(@Valid @RequestBody Etudiant etudiant) throws Exception {
        Etudiant newEtudiant = this.etudiantService.addEtudiant(etudiant);
        return newEtudiant;
    }
}
