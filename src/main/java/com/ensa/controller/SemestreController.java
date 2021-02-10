package com.ensa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.dto.SemestreDTO;
import com.ensa.entities.Semestre;
import com.ensa.services.SemestreService;

@RestController
@RequestMapping(path = "/api/semestres/")
public class SemestreController {

	@Autowired
	private SemestreService semestreService;


    @GetMapping
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ETUDIANT')")
    public List<Semestre> getListSemstres() {
        return this.semestreService.getSemestres();
    }

    @GetMapping(path = "{id}")
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ETUDIANT')")
    public Semestre getListSemstre(@PathVariable("id") Long id) throws Exception {
        return this.semestreService.getSemestre(id);
    }

    @GetMapping(path = "niveau/{id}")
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ETUDIANT')")
    public List<Semestre> getListSemstresNiveau(@PathVariable("id") Long id) throws Exception {
        return this.semestreService.getSemestresNiveau(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ETUDIANT')")
    public ResponseEntity<?> addSemestre(@RequestBody SemestreDTO s) {
        try {
            Semestre semestre = this.semestreService.addSemestre(s);
            return ResponseEntity.ok(semestre);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }
}
