package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByMail(String mail);
	
}
