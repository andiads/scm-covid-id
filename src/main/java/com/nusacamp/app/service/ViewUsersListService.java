package com.nusacamp.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.User;
import com.nusacamp.app.entity.ViewUsersList;
import com.nusacamp.app.repository.ViewUsersListRepository;

import lombok.RequiredArgsConstructor;

/** @author Muhamad Sholihin **/

@Service
@RequiredArgsConstructor
public class ViewUsersListService {

	private final ViewUsersListRepository viewUsersListRepository;
	
	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<ViewUsersList, Integer> getRepository() {
        return viewUsersListRepository;
    }

	public Page<ViewUsersList> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id");

        return getRepository().findAll(pageRequest);
	}
	
	public ViewUsersList findByMail(String mail) {
		return this.viewUsersListRepository.findByMail(mail);
	}
	
}
