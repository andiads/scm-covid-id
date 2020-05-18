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
@Table(name= "distribution_transaction")
public class DistributionTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDistribution;
	private int idItem;
	private int idLab;
	private int qty;
	@Column(name = "send_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private String sendAt;
	private int accepted=0;
	private String acceptedAt;
}
