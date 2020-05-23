package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.StockItem;

@Repository
public interface StockItemRepository extends JpaRepository<StockItem, Integer> {

	@Query(
		value = "SELECT amount FROM stock_item s WHERE s.id_item = :idItem AND s.id_source = :idSource", 
		nativeQuery = true)
	public int findAmountByItemAndSource(@Param("idItem") int idItem, @Param("idSource") int idSource);
	
	@Query(
		value = "SELECT * FROM stock_item s WHERE s.id_item = :idItem AND s.id_source = :idSource",
		nativeQuery = true)
	public StockItem findStockItemByItemAndSource(@Param("idItem") int idItem, @Param("idSource") int idSource);
	
}
