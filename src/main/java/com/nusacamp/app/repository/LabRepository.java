package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.Lab;


@Repository
public interface LabRepository extends JpaRepository<Lab, Integer>{
	
}
