package com.ensa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.Absence;
import com.ensa.services.AbsenceService;

@RestController
@RequestMapping(path = "/api/absences/")
public class AbsenceController {

	@Autowired
	AbsenceService absenceService;
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN')")
    public Absence addAbsence(@Valid @RequestBody Absence absence) throws Exception {
        Absence abs = this.absenceService.addAbsence(absence);
        return abs;
    }

    @PutMapping(path = "{id}")
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN')")
    public Absence updateAbsence(@PathVariable("id") Long id, @RequestBody Absence absence) throws Exception {
        Absence abs = this.absenceService.updateAbsence(id, absence);
        return abs;
    }

    @GetMapping(path = "{idModule}")
    @PreAuthorize("hasRole('ROLE_ETUDIANT') or hasRole('ROLE_ADMIN')")
    public  List<Absence> getAbsenceByIdModule(@PathVariable("idModule") Long id) throws Exception {
        List<Absence> abs = this.absenceService.findAbsenceByIdModule(id);
        return abs;
    }

    @GetMapping(path = "{idEtudiant}/{idModule}")
    @PreAuthorize("hasRole('ROLE_ETUDIANT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ENSEIGNANT')")
    public Long getNbrTotaleAbsenceParModule(@PathVariable("idModule") Long idModule,
            @PathVariable("idEtudiant") Long idEtudiant) throws Exception {
        Long nbrAbsenceByEtudiat = this.absenceService.getNbrTotaleAbsenceParModule(idModule, idEtudiant);
        return nbrAbsenceByEtudiat;
    }
	
	
}
