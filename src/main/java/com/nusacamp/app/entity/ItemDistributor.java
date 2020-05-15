package com.nusacamp.app.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "item_distributor")
public class ItemDistributor {
	
	private int idDistributor;
	private String distributorName;
	private String distributorCode;
	private int shown;
}
