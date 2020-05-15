package com.nusacamp.app.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_types",
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "user_type_id", referencedColumnName = "id"))
	@Column(name="user_type")
	private Collection<UserType> userTypes;
	
	
	@Column(name="created_at")
	private String createdAt;
	@Column(name="updated_at")
	private String updatedAt;
	
	
	
	public User(int id, String mail, String fullname, String password, Collection<UserType> userTypes, String createdAt,
			String updatedAt) {
		super();
		this.id = id;
		this.mail = mail;
		this.fullname = fullname;
		this.password = password;
		this.userTypes = userTypes;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public User() {
		
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<UserType> getUserTypes() {
		return userTypes;
	}
	public void setUserTypes(Collection<UserType> userTypes) {
		this.userTypes = userTypes;
	}
	
	
	
}
