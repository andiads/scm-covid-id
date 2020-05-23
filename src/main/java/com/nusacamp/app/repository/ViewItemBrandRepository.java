package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ViewItemBrand;

@Repository
public interface ViewItemBrandRepository extends JpaRepository<ViewItemBrand, Integer> {

}
