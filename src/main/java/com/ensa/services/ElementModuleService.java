package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.dto.ElementModuleDTO;
import com.ensa.entities.ElementModule;
import com.ensa.entities.Enseignant;
import com.ensa.repositories.ElementModuleRepo;
import com.ensa.repositories.EnseignantRepo;
import com.ensa.repositories.ModuleRepo;

@Service
public class ElementModuleService {

	private ElementModuleRepo elementModuleRepository;
	@Autowired
    private ModuleRepo moduleRepository;
	@Autowired
    private EnseignantRepo profRepository;
    
    @Autowired
    public ElementModuleService(ElementModuleRepo elementModuleRepository) {
        this.elementModuleRepository = elementModuleRepository;
    }

    public ElementModule addElementModule(ElementModuleDTO elemntModuleDTO) throws Exception {
        if (elemntModuleDTO.getElement_module() == null)
            throw new Exception("Le nom du l'element");
        ElementModule elementModule = new ElementModule();
        Enseignant prof =profRepository.findById(elemntModuleDTO.getProf()).get();
        com.ensa.entities.Module module =moduleRepository.findById(elemntModuleDTO.getModule()).get();
        elementModule.setLibelle(elemntModuleDTO.getElement_module());
        elementModule.setModule(module);
        elementModule.setProf(prof);
        return this.elementModuleRepository.save(elementModule);
    }

    public ElementModule updateElementModule(Long id, ElementModule elementModule) throws Exception {
        if (id == null)
            throw new Exception("Id est obligatoire");

        elementModule.setId(id);
        return this.elementModuleRepository.save(elementModule);
    }

    public ElementModule getElementModule(Long id) throws Exception {
        if (id == null)
            throw new Exception("Id est obligatoire");
        return this.elementModuleRepository.findById(id).orElseThrow(() -> new Exception("No module found"));
    }

    public List<ElementModule> listModuleParProf(Long idProf) throws Exception {
        if (idProf == null)
            throw new Exception("Id est obligatoire");

        List<ElementModule> elementModules = this.elementModuleRepository.findByIdProf(idProf);
        return elementModules;
    }

}
