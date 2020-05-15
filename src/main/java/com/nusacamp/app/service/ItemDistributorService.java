package com.nusacamp.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.ItemDistributor;
import com.nusacamp.app.repository.ItemDistributorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemDistributorService {

	private final ItemDistributorRepository itemDistributorRepo;
	
	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<ItemDistributor, Integer> getRepository(){
		return itemDistributorRepo;
	}
	
	public Page<ItemDistributor> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idDistributor");

        return getRepository().findAll(pageRequest);
	}
	
	public void saveItemDistributor(ItemDistributor itemDistributor) {
		itemDistributorRepo.save(itemDistributor);
	}
	
	public ItemDistributor getItemDistributor(int idDistributor) {
		return itemDistributorRepo.findById(idDistributor).get();
	}
}
