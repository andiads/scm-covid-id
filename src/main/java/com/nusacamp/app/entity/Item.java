package com.nusacamp.app.entity;

import javax.persistence.Column;
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
	@Column(name="id_item")
	private int idItem;
	@Column(name="item_code")
	private String itemCode;
	@Column(name="item_name")
	private String itemName;
	@Column(name="item_pieces_packaging")
	private int itemPiecesPackaging;
	@Column(name="item_packaging")
	private String itemPackaging;
	private int idCategory;
	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private String createdAt;
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private String updatedAt;
	@Column(name="shown")
	private int shown;
	@Column(name="created_by")
	private int createdBy=1;
	@Column(name="id_brand")
	private int idBrand;
	@Column(name="id_distributor")
	private int idDistributor;
}
