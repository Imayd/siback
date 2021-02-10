package com.ensa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ensa.dto.CoursDTO;
import com.ensa.entities.Cours;
import com.ensa.services.CoursService;

@RestController
@RequestMapping(path = "/api/cours")
public class CoursController {

	@Autowired
	private CoursService coursService;
	
	@PostMapping(value = "/")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Cours addCours(@Valid @RequestBody CoursDTO c) throws Exception {
		System.out.println(c);
        Cours cours = this.coursService.addCours(c);
        return cours;
    }
	
	@PutMapping(path = "{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Cours updateCours(@PathVariable("id") Long id, @Valid @RequestBody Cours c) throws Exception {
        Cours cours = this.coursService.updateCours(id, c);
        return cours;
    }
	
	 @GetMapping(value = "/byQuery")
	 @PreAuthorize("hasRole('ROLE_ETUDIANT') or hasRole('ROLE_ADMIN')")
	    public List<Cours> getCoursByQuery(@RequestParam("label") String label) {
	        List<Cours> cours = this.coursService.findCoursByQuery(label);
	        return cours;
	 }
	 
	 
	 @DeleteMapping(value = "{id}")
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public void deleteCours(@PathVariable("id") Long param) throws Exception {
	        this.coursService.deleteCours(param);
	 }
	 
	 @GetMapping(value = "/byMotCle")
	 @PreAuthorize("hasRole('ROLE_ETUDIANT') or hasRole('ROLE_ADMIN')")
	    public Cours getCoursByMotCle(@RequestParam("motCle") String motCle) {
	        Cours cours = this.coursService.findCoursByMotCle(motCle);
	        return cours;
	 }
	 
	 @GetMapping(value = "/")
	 @PreAuthorize("hasRole('ROLE_ETUDIANT') or hasRole('ROLE_ADMIN')")
	    public List<Cours> getListCours() {
	        List<Cours> cours = this.coursService.getListCours();
	        return cours;
	 }
	 
}
