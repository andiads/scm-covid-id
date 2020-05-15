package com.nusacamp.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.Item;
import com.nusacamp.app.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

	private final ItemRepository itemRepository;
	
	private static final int PAGE_SIZE = 10;
	
	protected JpaRepository<Item, Integer> getRepository(){
		return itemRepository;
	}
	
	public Page<Item> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idItem");

        return getRepository().findAll(pageRequest);
	}
	
	public void saveItem(Item item) {
		itemRepository.save(item);
	}
	
	public Item getById(int idItem) {
		return itemRepository.findById(idItem).get();
	}

}
