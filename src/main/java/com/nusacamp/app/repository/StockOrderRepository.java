package com.nusacamp.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nusacamp.app.entity.StockOrder;

@Repository
public interface StockOrderRepository extends JpaRepository<StockOrder, Integer>{

}
