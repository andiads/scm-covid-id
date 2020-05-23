package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ViewStockItem;

@Repository
public interface ViewStockItemRepository extends JpaRepository<ViewStockItem, Integer> {

}
