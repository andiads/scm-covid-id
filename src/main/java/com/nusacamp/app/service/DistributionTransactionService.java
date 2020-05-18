package com.nusacamp.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.DistributionTransaction;
import com.nusacamp.app.repository.DistributionTransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DistributionTransactionService {

	private final DistributionTransactionRepository distribTransRepo;
	
	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<DistributionTransaction, Integer> getRepository(){
		return distribTransRepo;
	}
	
	public Page<DistributionTransaction> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idDistribution");

        return getRepository().findAll(pageRequest);
	}
	
	public List<DistributionTransaction> getListTrx(){
		return distribTransRepo.findAll();
	}
	
	public void saveDistribTrans(DistributionTransaction distribTrx) {
		distribTransRepo.save(distribTrx);
	}
	
	public DistributionTransaction getDistribTrx(int idDistribution) {
		return distribTransRepo.findById(idDistribution).get();
	}
}
