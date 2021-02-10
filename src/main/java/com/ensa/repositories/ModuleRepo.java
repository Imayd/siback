package com.ensa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepo extends JpaRepository<com.ensa.entities.Module, Long> {

	@Query("from Module m where m.semestre.id = :id")
    public List<Module> findAllModuleBySemestre(@Param("id") Long idSemester);
}
