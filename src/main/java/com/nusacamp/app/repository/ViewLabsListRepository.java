package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ViewLabsList;

/** @author Muhamad Sholihin **/

@Repository
public interface ViewLabsListRepository extends JpaRepository<ViewLabsList, Integer>{

}
