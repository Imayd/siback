package com.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Service;

@Repository
public interface ServiceRepo extends JpaRepository<Service, Long> {

}
