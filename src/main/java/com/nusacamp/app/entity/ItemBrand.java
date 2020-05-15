package com.nusacamp.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="item_brand")
public class ItemBrand {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBrand;
	private String brandCode;
	private String brandName;
	private int shown;
}
