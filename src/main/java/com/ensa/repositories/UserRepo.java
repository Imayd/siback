package com.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
