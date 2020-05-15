package com.nusacamp.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="mail")
	private String mail;
	@Column(name="fullname")
	private String fullname;
	@Column(name="password")
	private String password;
	@Column(name="user_type")	
	private int userType;
	@Column(name="created_at")
	private String createdAt;
	@Column(name="updated_at")
	private String updatedAt;
	
}
