package com.nusacamp.app.service;

import java.sql.Timestamp;

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
import com.nusacamp.app.web.dto.UserRegistrationDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	private final ViewUsersListRepository viewUsersListRepository;
	
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

	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Timestamp ts = new Timestamp(new java.util.Date().getTime());
		user.setCreatedAt(ts.toString().substring(0,18));
		user.setUpdatedAt(ts.toString().substring(0,18));
		userRepository.save(user);
		
	}
	
	public User getUser(int id) {
		return userRepository.findById(id).get();
	}
}