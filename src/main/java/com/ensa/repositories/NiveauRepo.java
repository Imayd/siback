package com.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Niveau;

@Repository
public interface NiveauRepo extends JpaRepository<Niveau, Long> {

}
