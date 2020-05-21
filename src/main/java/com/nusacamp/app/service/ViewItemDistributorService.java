package com.nusacamp.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.ViewItemDistributor;
import com.nusacamp.app.repository.ViewItemDistributorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewItemDistributorService {
	
	private final ViewItemDistributorRepository viewItemDistributorRepo;

	private static final int PAGE_SIZE = 5;

	protected JpaRepository<ViewItemDistributor, Integer> getRepository(){
		return viewItemDistributorRepo;
	}

	public Page<ViewItemDistributor> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idDistributor");

        return getRepository().findAll(pageRequest);
	}

}
