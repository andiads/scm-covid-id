package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ItemDistributor;

@Repository
public interface ItemDistributorRepository extends JpaRepository<ItemDistributor, Integer> {

}