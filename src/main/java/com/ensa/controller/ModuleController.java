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

import com.ensa.dto.ModuleDTO;
import com.ensa.services.ModuleService;

@RestController
@RequestMapping(path = "/api/modules")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;

    @PostMapping(path = "/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addModule(@RequestBody ModuleDTO entity) {
        try {
        	com.ensa.entities.Module m = this.moduleService.addModule(entity);
            return ResponseEntity.ok().body(m);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }

    }

    @GetMapping(path = "/semestre/{id}")
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ETUDIANT')")
    public List<Module> getModulesBySemestre(@PathVariable("id") Long id) throws Exception {
        return this.moduleService.listModulesBySemester(id);
    }
}
