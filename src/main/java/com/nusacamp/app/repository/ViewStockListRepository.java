package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewStockListRepository extends JpaRepository<ViewStockListRepository, Integer> {

}
