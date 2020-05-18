package com.nusacamp.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ViewItemsList;

/** @author Muhamad Sholihin **/

@Repository
public interface ViewItemsListRepository extends JpaRepository<ViewItemsList, Integer>{

	public ViewItemsList findByItemName(@Param("itemName") String itemName);
	
	public ViewItemsList findByCategoryName(@Param("categoryName") String categoryName);

	@Query(
			value="SELECT * FROM view_items_list v WHERE v.shown = 1",
			nativeQuery = true)
	public Page<ViewItemsList> findAllAvailableItems(Pageable p);
	
	
	@Query(
			value="SELECT * FROM view_items_list v WHERE v.shown = 0",
			nativeQuery = true)
	public Page<ViewItemsList> findAllDeletedItems(Pageable p);
	
}
