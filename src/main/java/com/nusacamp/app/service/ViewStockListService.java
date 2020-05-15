package com.nusacamp.app.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.StockOrder;
import com.nusacamp.app.entity.ViewStockList;
import com.nusacamp.app.repository.ViewStockListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewStockListService {
	
	private final ViewStockListRepository viewStockListRepo;
	
	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<ViewStockList> getList(Integer pageNumber){
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idStock");

        return getRepository().findAll(pageRequest);
	}
	
	public void saveViewStockList(ViewStockList viewStockList) {
		viewStockListRepo.findById(idStock).get();
	}
	
	public ViewStockList getViewStockList(int idStock) {
		return viewStockListRepo.findById(idStock).get();
	}
	
}
