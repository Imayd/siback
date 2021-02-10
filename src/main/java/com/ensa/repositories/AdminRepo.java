package com.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

}
