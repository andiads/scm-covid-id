package com.nusacamp.app.service;

import org.springframework.stereotype.Service;

import com.nusacamp.app.repository.ViewUsersListRepository;

import lombok.RequiredArgsConstructor;

/** @author Muhamad Sholihin **/

@Service
@RequiredArgsConstructor
public class ViewUsersListService {

	private final ViewUsersListRepository viewUsersListRepository;
	
}
