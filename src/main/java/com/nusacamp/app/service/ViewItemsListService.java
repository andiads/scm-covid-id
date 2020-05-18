package com.nusacamp.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.Item;
import com.nusacamp.app.entity.ViewItemsList;
import com.nusacamp.app.repository.ViewItemsListRepository;

import lombok.RequiredArgsConstructor;

/** @author Muhamad Sholihin **/

@Service
@RequiredArgsConstructor
public class ViewItemsListService {

	private final ViewItemsListRepository viewItemsListRepository;
	
	private static final int PAGE_SIZE = 10;
	
	protected JpaRepository<ViewItemsList, Integer> getRepository(){
		return viewItemsListRepository;
	}
	
	public Page<ViewItemsList> getAllAvailableList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id_item");

        return this.viewItemsListRepository.findAllAvailableItems(pageRequest);
	}
	
	public Page<ViewItemsList> getAllDeletedList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id_item");

        return this.viewItemsListRepository.findAllDeletedItems(pageRequest);
	}
	
	public ViewItemsList getById(int idItem) {
		return this.viewItemsListRepository.findById(idItem).get();
	}

}
