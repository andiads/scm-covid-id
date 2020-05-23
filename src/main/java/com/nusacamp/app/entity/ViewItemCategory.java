package com.nusacamp.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="view_item_category_list")
public class ViewItemCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategory;
	private String categoryCode;
	private String categoryName;
}
