package com.nusacamp.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idItem;
	private String itemCode;
	private String itemName;
	private int itemPiecesPackaging;
	private int idCategory;
	private String createdAt;
	private String updatedAt;
	private int shown;
	private int createdBy;
	private int idBrand;
	private int idDistributor;
	private int idSto;
	private int idLab;
}
