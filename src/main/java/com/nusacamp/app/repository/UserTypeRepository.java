package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}
