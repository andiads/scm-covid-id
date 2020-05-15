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
@Table(name = "view_items_list")
public class ViewItemsList {

	@Id
	@Column(name = "id_item")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idItem;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "item_packaging")
	private String itemPackaging;
	@Column(name = "item_pieces_packaging")
	private Integer itemPiecesPackaging;
	@Column(name = "brand_name")
	private String brandName;
	@Column(name = "category_name")
	private String categoryName;

}
