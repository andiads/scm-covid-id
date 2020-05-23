package com.nusacamp.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.ViewItemCategory;
import com.nusacamp.app.repository.ViewItemCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewItemCategoryService {
	
	private final ViewItemCategoryRepository viewItemCategoryRepo;

	private static final int PAGE_SIZE = 5;

	protected JpaRepository<ViewItemCategory, Integer> getRepository(){
		return viewItemCategoryRepo;
	}

	public Page<ViewItemCategory> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idCategory");

        return getRepository().findAll(pageRequest);
	}

}
