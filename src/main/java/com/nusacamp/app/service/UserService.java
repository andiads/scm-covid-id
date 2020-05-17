package com.nusacamp.app.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.User;
import com.nusacamp.app.entity.ViewUsersList;
import com.nusacamp.app.repository.UserRepository;
import com.nusacamp.app.repository.ViewUsersListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	private final ViewUsersListRepository viewUsersListRepository;
	
	@Autowired
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private static final int PAGE_SIZE = 5;
	
	protected JpaRepository<User, Integer> getRepository() {
        return userRepository;
    }

	public Page<User> getList(Integer pageNumber) {
		PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id");

        return getRepository().findAll(pageRequest);
	}
	
	public ViewUsersList findByMail(String mail) {
		return this.viewUsersListRepository.findByMail(mail);
	}

	//for hasing password
	public User save(User user) {
		user.setMail(user.getMail());
		user.setFullname(user.getFullname());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserType(user.getUserType());
		return userRepository.save(user);
		
	}
	
	public User getUser(int id) {
		return userRepository.findById(id).get();
	}
}