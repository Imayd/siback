package com.ensa.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestAPIs {
	
	@GetMapping("/api/test/internaute")
	//@PreAuthorize("hasRole('ROLE_INTERNAUTE') or hasRole('ROLE_ADMIN')")
	public String userAccess() {
		return ">>> Public Contents!";
	}

	@GetMapping("/api/test/etudiant")
	@PreAuthorize("hasRole('ROLE_ETUDIANT') or hasRole('ROLE_ADMIN')")
	public String etudiantAccess() {
		return ">>> ETUDIANT Contents!";
	}
	
	@GetMapping("/api/test/enseignant")
	@PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN')")
	public String EnseignantAccess() {
		return ">>> ENSEIGNANT Contents!";
	}
	
	@CrossOrigin
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}
}
