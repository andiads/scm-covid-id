package com.nusacamp.app.service;

import java.util.List;

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
	
	public List<ItemDistributor> getItemDistrib(){
		return itemDistributorRepo.findAll();
	}
	public void saveItemDistributor(ItemDistributor itemDistributor) {
		itemDistributorRepo.save(itemDistributor);
	}
	
	public ItemDistributor getItemDistributor(int idDistributor) {
		return itemDistributorRepo.findById(idDistributor).get();
	}
	
	public void deleteDistributor(ItemDistributor itemDistributor) {
		itemDistributor.setShown(0);
		this.itemDistributorRepo.save(itemDistributor);
	}
}
