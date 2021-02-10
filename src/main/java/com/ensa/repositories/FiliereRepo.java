package com.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Filiere;

@Repository
public interface FiliereRepo extends JpaRepository<Filiere, Long> {

}
