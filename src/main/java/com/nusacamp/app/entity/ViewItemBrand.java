package com.nusacamp.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="view_item_brand_list")
public class ViewItemBrand {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBrand;
	private String brandCode;
	private String brandName;
}
