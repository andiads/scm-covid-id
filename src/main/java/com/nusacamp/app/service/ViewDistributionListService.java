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

	private final ViewDistributionListRepository viewDistributionListRepository;
	
	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<ViewDistributionList, Integer> getRepository(){
		return viewDistributionListRepository;
	}
	
	public Page<ViewDistributionList> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idDistribution");

        return getRepository().findAll(pageRequest);
	}
	
	
	
	public ViewDistributionList getViewDistributionList(int idDistribution) {
		return viewDistributionListRepository.findById(idDistribution).get();
	}
}
