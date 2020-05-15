package com.nusacamp.app.service;

import com.nusacamp.app.entity.User;
import com.nusacamp.app.entity.UserType;
import com.nusacamp.app.entity.ViewUsersList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

//	@Autowired
//	private UserService userService;
	
	@Autowired
	private ViewUsersListService userService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		ViewUsersList user = userService.findByMail(userName);
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getTypeName()));
		
		return new org.springframework.security.core.userdetails.User (
				user.getMail(),
				user.getPassword(),
				grantedAuthorities
		);
	}
}