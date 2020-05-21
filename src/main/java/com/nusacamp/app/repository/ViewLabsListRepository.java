package com.nusacamp.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ViewLabsList;

/** @author Muhamad Sholihin **/

@Repository
public interface ViewLabsListRepository extends JpaRepository<ViewLabsList, Integer>{

	@Query(
			value="SELECT * FROM view_labs_list v WHERE v.shown = 1",
			nativeQuery = true)
	public Page<ViewLabsList> findAllAvailableLabs(Pageable p);
	
}
