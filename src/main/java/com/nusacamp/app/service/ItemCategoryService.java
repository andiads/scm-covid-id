package com.nusacamp.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.ItemCategory;
import com.nusacamp.app.repository.ItemCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemCategoryService {
	
	private final ItemCategoryRepository itemCategoryRepo;
	
	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<ItemCategory, Integer> getRepository(){
		return itemCategoryRepo;
	}
	
	public Page<ItemCategory> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idCategory");

        return getRepository().findAll(pageRequest);
	}	
	
	public List<ItemCategory> getItemCategory(){
		return itemCategoryRepo.findAll();
	}
		
	public void saveItemCategory(ItemCategory itemCategory) {
		itemCategoryRepo.save(itemCategory);
	}
	
	public ItemCategory getItemCategory(int idCategory) {
		return itemCategoryRepo.findById(idCategory).get();
	}

}
