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
@Table(name = "labs")
public class Lab {

	@Id
	@Column(name = "id_lab")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLab;
	@Column(name = "lab_code")
	private String labCode;
	@Column(name = "password")
	private String password;
	@Column(name = "lab_name")
	private String labName;
	@Column(name = "lab_address")
	private String labAddress;
	@Column(name = "lab_pic")
	private String labPic;
	@Column(name = "lab_mail")
	private String labMail;
	@Column(name = "created_at")
	private String createdAt;
	@Column(name = "updated_at")
	private String updatedAt;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "shown")
	private Integer shown = 1;
	@Column(name = "lab_contact")
	private String labContact;

}
