package com.ensa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.dto.ServiceDTO;
import com.ensa.services.ServiceService;

@RestController
@RequestMapping(path = "/api/services")
public class ServiceController {

	@Autowired
	private ServiceService serviceService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ETUDIANT') or hasRole('ROLE_ADMIN')")
    public com.ensa.entities.Service demanderService(@RequestBody ServiceDTO servicedto) throws Exception {
        return this.serviceService.demanderService(servicedto);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<com.ensa.entities.Service> getAllServices() {
        return this.serviceService.getAllServices();
    }

}
