package com.nusacamp.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.StockSource;

@Repository
public interface StockSourceRepository extends JpaRepository<StockSource, Integer> {

	@Query(
			value="SELECT * FROM stock_source i WHERE i.shown = 1",
			nativeQuery = true)
	public List<StockSource> findAllAvailableSources();
	
	@Query(
			value="SELECT * FROM stock_source i WHERE i.shown = 0",
			nativeQuery = true)
	public List<StockSource> findAllDeletedSources();
}
