package com.sis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sis.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
