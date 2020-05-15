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

	private int idDistribution;
	private String labName;
	private String itemName;
	private String distributorName;
	private String stockSendTime;
	private String stockArriveTime;
	
	
}
