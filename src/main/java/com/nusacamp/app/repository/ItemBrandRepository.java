package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ItemBrand;

@Repository
public interface ItemBrandRepository extends JpaRepository<ItemBrand, Integer> {

}
