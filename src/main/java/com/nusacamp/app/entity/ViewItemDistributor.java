package com.nusacamp.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="view_item_distributor_list")
public class ViewItemDistributor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDistributor;
	private String distributorCode;
	private String distributorName;
}
