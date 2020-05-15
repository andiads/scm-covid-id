package com.nusacamp.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.StockOrder;
import com.nusacamp.app.repository.StockOrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockOrderService {

		private final StockOrderRepository stockOrderRepo;
		
		private static final int PAGE_SIZE = 5;
		
		protected JpaRepository<StockOrder, Integer> getRepository(){
			return stockOrderRepo;
		}
		
		public Page<StockOrder> getList(Integer pageNumber) {
			PageRequest pageRequest =
	                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idStockOrder");

	        return getRepository().findAll(pageRequest);
		}
		
		public void saveStockOrder(StockOrder stockOrder) {
			stockOrderRepo.save(stockOrder);
		}
		
		public StockOrder getStockOrder(int idStockOrder) {
			return stockOrderRepo.findById(idStockOrder).get();
		}
		
		
}
