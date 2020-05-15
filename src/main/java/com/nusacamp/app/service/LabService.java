package com.nusacamp.app.service;

import org.springframework.stereotype.Service;

import com.nusacamp.app.repository.LabRepository;

import lombok.RequiredArgsConstructor;

/** @author Muhamad Sholihin **/

@Service
@RequiredArgsConstructor
public class LabService {

	private final LabRepository labRepository;
	
}
