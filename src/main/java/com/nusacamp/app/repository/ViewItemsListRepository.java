package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ViewItemsList;

/** @author Muhamad Sholihin **/

@Repository
public interface ViewItemsListRepository extends JpaRepository<ViewItemsList, Integer>{

}
