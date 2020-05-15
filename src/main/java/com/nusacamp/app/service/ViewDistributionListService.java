package com.nusacamp.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.ViewDistributionList;
import com.nusacamp.app.repository.ViewDistributionListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewDistributionListService {

	private final ViewDistributionRepository viewDistributionListRepo;
	
	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<ViewDistributionList, Integer> getRepository(){
		return viewDistributionListRepo;
	}
	
	public Page<ViewDistributionList> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idDistribution");

        return getRepository().findAll(pageRequest);
	}
	
	public void saveViewDistributionList(ViewDistributionList viewDistributionList) {
		viewDistributionListRepo.save(viewDistributionList);
	}
	
	public ViewDistributionList getViewDistributionList(int idDistribution) {
		return viewDistributionListRepo.findById(idDistribution).get();
	}
}
