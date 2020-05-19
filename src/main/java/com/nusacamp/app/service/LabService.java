package com.nusacamp.app.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.Item;
import com.nusacamp.app.entity.Lab;
import com.nusacamp.app.repository.LabRepository;

import lombok.RequiredArgsConstructor;

/** @author Muhamad Sholihin **/

@Service
@RequiredArgsConstructor
public class LabService {

	private final LabRepository labRepository;
	
	private static final int PAGE_SIZE=5;
	
	protected JpaRepository<Lab, Integer> getRepository(){
		return labRepository;
	}
	
	public Page<Lab> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "idLab");

        return getRepository().findAll(pageRequest);
	}
	

	public List<Lab> getAllLabs() {
		return labRepository.findAll();
	}

	public void saveLabs(Lab lab) {
		lab.setShown(1);
		labRepository.save(lab);
	}
	
	public Lab getLab(int idLab) {
		return labRepository.findById(idLab).get();
	}

	public void deleteLab(Lab lab) {
		lab.setShown(0);
		this.labRepository.save(lab);
	}
	
}
