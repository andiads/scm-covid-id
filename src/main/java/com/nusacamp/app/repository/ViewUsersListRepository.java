package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ViewUsersList;

/** @author Muhamad Sholihin **/

@Repository
public interface ViewUsersListRepository extends JpaRepository<ViewUsersList, Integer>{

}
