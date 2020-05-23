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
@Table(name="stock_source")
public class StockSource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_source")
	private int idSource;
	@Column(name="source_name")
	private String sourceName;
	@Column(name="source_address")
	private String sourceAddress;
	@Column(name="shown")
	private int shown;
	
	
}
