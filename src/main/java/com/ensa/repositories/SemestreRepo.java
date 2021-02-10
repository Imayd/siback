package com.ensa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Semestre;

@Repository
public interface SemestreRepo extends JpaRepository<Semestre, Long> {

	 @Query("from Semestre s where s.niveau.id = :idNiveau")
	 public List<Semestre> getSemestreOfNiveau(@Param("idNiveau") Long id);
}
