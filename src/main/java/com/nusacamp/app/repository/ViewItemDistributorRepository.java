package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ViewItemDistributor;

@Repository
public interface ViewItemDistributorRepository extends JpaRepository<ViewItemDistributor, Integer> {

}
