package com.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Etudiant;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {

}
