package com.ensa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.dto.ElementModuleDTO;
import com.ensa.entities.ElementModule;
import com.ensa.services.ElementModuleService;

@RestController
@RequestMapping(path = "/api/elementModule/")
public class ElementModuleController {

	@Autowired
	private ElementModuleService elementModuleService;
	

    @GetMapping(path = "{id}")
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ETUDIANT')")
    public ElementModule getElementModule(@PathVariable("id") Long id) throws Exception {
        return this.elementModuleService.getElementModule(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ElementModule addElementModule(@Valid @RequestBody ElementModuleDTO elementModule) throws Exception {
        return this.elementModuleService.addElementModule(elementModule);
    }

    @GetMapping(path = "enseignant/{id}")
    @PreAuthorize("hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ETUDIANT')")
    public List<ElementModule> getElementModuleByIdProf(@PathVariable("id") Long idProf) throws Exception {
        return this.elementModuleService.listModuleParProf(idProf);
    }
}
