package com.nusacamp.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.ItemBrand;
import com.nusacamp.app.repository.ItemBrandRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemBrandService {
	
	private final ItemBrandRepository itemBrandRepo;
	
	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<ItemBrand, Integer> getRepository(){
		return itemBrandRepo;
	}
	
	public Page<ItemBrand> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idBrand");

        return getRepository().findAll(pageRequest);
	}
	
	public List<ItemBrand> getItemBrand(){
		return itemBrandRepo.findAll();
	}
	
	public void saveItemBrand(ItemBrand itemBrand) {
		itemBrandRepo.save(itemBrand);
	}
	
	public ItemBrand getItemBrand(int idBrand) {
		return itemBrandRepo.findById(idBrand).get();
	}

}
