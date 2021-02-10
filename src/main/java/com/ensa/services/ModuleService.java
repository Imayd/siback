package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.dto.ModuleDTO;
import com.ensa.entities.Semestre;
import com.ensa.repositories.ModuleRepo;
import com.ensa.repositories.SemestreRepo;

@Service
public class ModuleService {

	 @Autowired
	private ModuleRepo moduleRepository;
	 @Autowired
    private SemestreRepo semestreRepository;


    public com.ensa.entities.Module addModule(ModuleDTO moduleDTO) throws Exception {
        if (moduleDTO.getLibelle() == null)
            throw new Exception("Le nom du module est obligatoire");
        Semestre s = this.semestreRepository.findById(moduleDTO.getSemestre()).get();
        com.ensa.entities.Module module = new com.ensa.entities.Module();
        module.setLibelle(moduleDTO.getLibelle());
        module.setSemestre(s);

        return this.moduleRepository.save(module);
    }


    public List<Module> listModulesBySemester(Long idSemester) throws Exception {
        if (idSemester == null)
            throw new Exception("Id est obligatoire !!");
        return this.moduleRepository.findAllModuleBySemestre(idSemester);
    }
}
