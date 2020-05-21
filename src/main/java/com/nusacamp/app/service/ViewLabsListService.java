package com.nusacamp.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.Lab;
import com.nusacamp.app.entity.ViewLabsList;
import com.nusacamp.app.repository.ViewLabsListRepository;

import lombok.RequiredArgsConstructor;

/** @author Muhamad Sholihin **/

@Service
@RequiredArgsConstructor
public class ViewLabsListService {

	private final ViewLabsListRepository viewLabsListRepository;
	
	private static final int PAGE_SIZE=5;
	
	protected JpaRepository<ViewLabsList, Integer> getRepository(){
		return viewLabsListRepository;
	}
	
	public Page<ViewLabsList> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idLab");

        return getRepository().findAll(pageRequest);
	}

	public Page<ViewLabsList> getAvailableList(Integer pageNumber) {
		PageRequest pageRequest =
				PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id_lab");
		return this.viewLabsListRepository.findAllAvailableLabs(pageRequest);
	}
}
