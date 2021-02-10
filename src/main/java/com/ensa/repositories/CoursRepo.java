package com.ensa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Cours;

@Repository
public interface CoursRepo extends JpaRepository<Cours, Long> {

	
	public List<Cours> findByLabel(String libelle);

    @Query("FROM Cours cours WHERE cours.label LIKE %:query%")
    public List<Cours> findCoursByQuery(@Param("query") String query);
    
    @Query("FROM Cours cours WHERE cours.mot_clé = (:motCle)")
    public Cours findCoursByMotCle(@Param("motCle") String query);

    @Query("DELETE  FROM Cours cours WHERE cours.id = (:idCours)")
    public Cours deleteCourByID(@Param("idCours") Long id);
}
