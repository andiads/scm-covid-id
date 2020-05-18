package com.nusacamp.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.Item;
import com.nusacamp.app.entity.ViewItemsList;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	@Query(
			value="SELECT * FROM item i WHERE i.shown = 1",
			nativeQuery = true)
	public List<Item> findAllAvailableItems();
	
	@Query(
			value="SELECT * FROM item i WHERE i.shown = 0",
			nativeQuery = true)
	public List<Item> findAllDeletedItems();
	
	
}
