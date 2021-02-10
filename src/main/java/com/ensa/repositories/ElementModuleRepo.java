package com.ensa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ensa.entities.ElementModule;

@Repository
public interface ElementModuleRepo extends JpaRepository<ElementModule, Long> {

	@Query("from ElementModule el where el.prof.id = (:idProf)")
    public List<ElementModule> findByIdProf(@Param("idProf") Long idProf);

	@Query("from ElementModule el where el.libelle = (:libelle)")
    public ElementModule findByLibelle(@Param("libelle") String libelle);
}
