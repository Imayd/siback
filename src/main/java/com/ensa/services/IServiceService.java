package com.ensa.services;

import java.util.List;

import com.ensa.dto.ServiceDTO;


public interface IServiceService {

    
    public com.ensa.entities.Service demanderService(ServiceDTO serviceDTO) throws Exception ;
    
    public List<com.ensa.entities.Service> getAllServices();
}
