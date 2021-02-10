package com.ensa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.Filiere;
import com.ensa.services.FiliereService;

@RestController
@RequestMapping(path = "/api/filieres/")
public class FiliereController {

	@Autowired
	private FiliereService filiereService;
	
	

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Filiere addFiliere(
            @RequestParam("nomFormation") String nomFormation,
            @RequestParam("description") String description
    ) throws Exception {
        try {
            
            Filiere filiere = new Filiere();
            filiere.setNomFormation(nomFormation);
            filiere.setDescription(description);
            Filiere flr = this.filiereService.addFiliere(filiere);
            return flr;
        } catch (Exception e) {
            throw new Exception("Filiere not added try again");
        }
    }
	
    @GetMapping(params = "{id}")
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ETUDIANT')")
    public Filiere getFiliere(@PathVariable("id") Long id) throws Exception {
        Filiere flr = this.filiereService.getFiliere(id);
        return flr;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ETUDIANT')")
    public List<Filiere> getFilieres() throws Exception {
        List<Filiere> listFiliere = this.filiereService.getFilieres();
        return listFiliere;
    }

    @PutMapping(path = "{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Filiere updateFiliere(@PathVariable("id") Long id, @Valid @RequestBody Filiere entity) throws Exception {
        Filiere flr = this.filiereService.updateFiliere(id, entity);
        return flr;
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteFiliere(@PathVariable Long id) throws Exception {
        try {
            this.filiereService.deleteFiliere(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.ok().body(e);
        }
    }
}
