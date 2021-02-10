package com.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Enseignant;

@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant, Long> {

}
