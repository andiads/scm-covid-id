package com.nusacamp.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import com.nusacamp.app.entity.StockSource;
import com.nusacamp.app.repository.StockSourceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockSourceService {

	private final StockSourceRepository stockSourceRepository;
	
	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<StockSource, Integer> getRepository(){
		return stockSourceRepository;
	}
	
	public Page<StockSource> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idSource");

        return getRepository().findAll(pageRequest);
	}
	
	public List<StockSource> getAllSource() {
		return this.stockSourceRepository.findAll();
	}
	
	public List<StockSource> getAllAvailableSources() {
		return this.stockSourceRepository.findAllAvailableSources();
	}
	
	public List<StockSource> getAllDeletedSources() {
		return this.stockSourceRepository.findAllDeletedSources();
	}
	
	public void saveStockSource(StockSource stockSource) {
		stockSourceRepository.save(stockSource);
	}
	
	public StockSource getStockSource(int idSource) {
		return this.stockSourceRepository.findById(idSource).get();
	}
}
