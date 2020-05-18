package com.nusacamp.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "view_distribution_list")
public class ViewDistributionList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDistribution;
	private String labDestination;
	private String sourceName;
	private String itemName;
	private int amount;
	private int status;
	private String sendAt;
	private String arrivedAt;
	private int shown;
	private String createdAt;
	private String updatedAt;
	
	
}
