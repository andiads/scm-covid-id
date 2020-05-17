package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.DistributionTransaction;

@Repository
public interface DistributionTransactionRepository extends JpaRepository<DistributionTransaction, Integer> {

}
