package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ViewItemsList;

/** @author Muhamad Sholihin **/

@Repository
public interface ViewItemsListRepository extends JpaRepository<ViewItemsList, Integer>{

	public ViewItemsList findByItemName(@Param("itemName") String itemName);
	
	public ViewItemsList findByCategoryName(@Param("categoryName") String categoryName);

}
