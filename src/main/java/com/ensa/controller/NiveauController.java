package com.ensa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.dto.NiveauDTO;
import com.ensa.entities.Niveau;
import com.ensa.services.NiveauService;

@RestController
@RequestMapping(path = "/api/niveaux")
public class NiveauController {

	@Autowired
	private NiveauService niveauService;


    @PostMapping(path = "/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addNiveau(@RequestBody NiveauDTO niveauDto) {
        try {
            Niveau niveau = this.niveauService.addNiveau(niveauDto);
            return ResponseEntity.ok().body(niveau);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @GetMapping(path = "/")
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ETUDIANT')")
    public ResponseEntity<?> getNiveaux() {
        try {
            List<Niveau> list = this.niveauService.getAllNiveaux();
            return ResponseEntity.ok(list);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
        }
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteNiveau(@PathVariable Long id) {
        try {
            this.niveauService.deleteNiveau(id);
            return ResponseEntity.ok("Niveau deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
