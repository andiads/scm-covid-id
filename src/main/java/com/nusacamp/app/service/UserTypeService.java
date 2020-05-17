package com.nusacamp.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.UserType;
import com.nusacamp.app.repository.UserTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserTypeService {

	private final UserTypeRepository userTypeRepo;
	
	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<UserType, Integer> getRepository(){
		return userTypeRepo;
	}
	
	public Page<UserType> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id");

        return getRepository().findAll(pageRequest);
	}
	
	public List<UserType> getUserType() {
		return userTypeRepo.findAll();
	}
	
	public void saveUserType(UserType userType) {
		userTypeRepo.save(userType);
	}
	
	public UserType getUserTypeId(int id) {
		return userTypeRepo.findById(id).get();
	}
}
