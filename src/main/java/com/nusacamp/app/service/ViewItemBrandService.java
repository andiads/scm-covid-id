package com.nusacamp.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.ItemBrand;
import com.nusacamp.app.entity.ViewItemBrand;
import com.nusacamp.app.repository.ItemBrandRepository;
import com.nusacamp.app.repository.ViewItemBrandRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewItemBrandService {
	
	private final ViewItemBrandRepository viewItemBrandRepo;
	
	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<ViewItemBrand, Integer> getRepository(){
		return viewItemBrandRepo;
	}
	
	public Page<ViewItemBrand> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idBrand");

        return getRepository().findAll(pageRequest);
	}

}
