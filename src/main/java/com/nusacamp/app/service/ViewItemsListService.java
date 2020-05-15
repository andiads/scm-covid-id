package com.nusacamp.app.service;

import org.springframework.stereotype.Service;

import com.nusacamp.app.repository.ViewItemsListRepository;

import lombok.RequiredArgsConstructor;

/** @author Muhamad Sholihin **/

@Service
@RequiredArgsConstructor
public class ViewItemsListService {

	private final ViewItemsListRepository viewItemsListRepository;
	
}
