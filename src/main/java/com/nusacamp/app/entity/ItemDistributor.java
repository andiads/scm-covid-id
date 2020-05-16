package com.nusacamp.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "item_distributor")
public class ItemDistributor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDistributor;
	private String distributorName;
	private String distributorCode;
	private int shown;
}
