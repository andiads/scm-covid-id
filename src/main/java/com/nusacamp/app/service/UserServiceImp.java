package com.nusacamp.app.service;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nusacamp.app.entity.User;
import com.nusacamp.app.entity.UserType;
import com.nusacamp.app.repository.UserRepository;
import com.nusacamp.app.web.dto.UserRegistrationDto;

public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		
		User user = userRepository.findByMail(mail);
		if(user==null) {
			throw new UsernameNotFoundException("invalid Username or Password");
		}
		return new org.springframework.security.core.userdetails.User(user.getMail()
				,user.getPassword()
				,mapUserTypesToAuthorities(user.getUserTypes()));
	}

	private Collection<? extends GrantedAuthority> mapUserTypesToAuthorities(Collection<UserType> userTypes) {
		return userTypes.stream()
				.map(userType -> new SimpleGrantedAuthority(userType.getTypeName()))
				.collect(Collectors.toList());
	}

	@Override
	public User findByMail(String mail) {
		
		return userRepository.findByMail(mail);
	}

	@Override
	public User save(UserRegistrationDto registration) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
