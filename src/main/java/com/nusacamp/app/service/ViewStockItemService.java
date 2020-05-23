package com.nusacamp.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.ViewStockItem;
import com.nusacamp.app.repository.ViewStockItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewStockItemService {

	private final ViewStockItemRepository viewStockItemRepo;

	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<ViewStockItem, Integer> getRepository() {
		return viewStockItemRepo;
	}
	
	public Page<ViewStockItem> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id");

        return getRepository().findAll(pageRequest);
	}
	
	
}
