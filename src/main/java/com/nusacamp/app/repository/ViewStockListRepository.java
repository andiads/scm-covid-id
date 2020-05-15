package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ViewStockList;

@Repository
public interface ViewStockListRepository extends JpaRepository<ViewStockList, Integer> {

}
