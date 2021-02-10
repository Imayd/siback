package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.dto.ServiceDTO;
import com.ensa.entities.Etudiant;
import com.ensa.repositories.EtudiantRepo;
import com.ensa.repositories.ServiceRepo;

@Service
public class ServiceService implements IServiceService {

	@Autowired
	private ServiceRepo serviceRepo;
	
	@Autowired
	private EtudiantRepo etudiantRepo;
	
	@Override
	public com.ensa.entities.Service demanderService(ServiceDTO serviceDTO) throws Exception {
		
		if (serviceDTO.getDescription() == null) {
            throw new Exception("La description ne doit pas etre null");
        }
		
		com.ensa.entities.Service service = new com.ensa.entities.Service();
		service.setDescription(serviceDTO.getDescription());
		Long idEtudiant = serviceDTO.getIdEtudiant();
		Etudiant e= etudiantRepo.findById(idEtudiant).get();
		//Optional<Etudiant> e = etudiantRepo.findById(idEtudiant);
		service.setEtudiant(e);
		System.out.println(service);
        return this.serviceRepo.save(service);
	}


	@Override
	public List<com.ensa.entities.Service> getAllServices() {
		
		return this.serviceRepo.findAll();
		
	}

}
