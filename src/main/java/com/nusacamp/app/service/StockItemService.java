package com.nusacamp.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.StockItem;
import com.nusacamp.app.repository.StockItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockItemService {

	private final StockItemRepository stockItemRepository;
	
	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<StockItem, Integer> getRepository() {
		return stockItemRepository;
	}
	
	public Page<StockItem> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idStockItem");

        return getRepository().findAll(pageRequest);
	}
	
	public List<StockItem> getAll() {
		return this.stockItemRepository.findAll();
	}
	
	public Optional<StockItem> getById(int id) {
		return this.stockItemRepository.findById(id);
	}
	
	public int getCurrentAmount(int idItem, int idSource) {
		return this.stockItemRepository.findAmountByItemAndSource(idItem, idSource);
	}
	
	public StockItem getStockItemByItemAndSource(int idItem, int idSource) {
		return this.stockItemRepository.findStockItemByItemAndSource(idItem, idSource);
	}
	
	public void save(StockItem stockItem) {
		stockItem.setShown(1);
		this.stockItemRepository.save(stockItem);
	}
	
	public void delete(StockItem stockItem) {
		stockItem.setShown(0);
		this.stockItemRepository.save(stockItem);
	}
}
