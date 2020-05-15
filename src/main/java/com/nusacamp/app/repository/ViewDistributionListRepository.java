package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ViewDistributionList;

@Repository
public interface ViewDistributionListRepository extends JpaRepository<ViewDistributionList, Integer>{

}
