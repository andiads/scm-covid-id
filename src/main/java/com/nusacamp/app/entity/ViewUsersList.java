package com.nusacamp.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/** @author Muhamad Sholihin **/

@Data
@Entity
@Table(name = "view_users_list")
public class ViewUsersList {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "mail")
	private String mail;
	@Column(name = "fullname")
	private String fullName;
	@Column(name = "password")
	private String password;
	@Column(name = "user_type")
	private Integer userType;
	@Column(name = "type_name")
	private String typeName;
	
}
