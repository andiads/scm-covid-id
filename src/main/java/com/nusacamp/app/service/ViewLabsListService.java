package com.nusacamp.app.service;

import org.springframework.stereotype.Service;

import com.nusacamp.app.repository.ViewLabsListRepository;

import lombok.RequiredArgsConstructor;

/** @author Muhamad Sholihin **/

@Service
@RequiredArgsConstructor
public class ViewLabsListService {

	private final ViewLabsListRepository viewLabsListRepository;
	
}
