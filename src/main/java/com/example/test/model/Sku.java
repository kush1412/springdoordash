package com.example.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "skus")
public class Sku {

	@Id
	@Column(name = "sku_id")
	private String skuId;
	
	@Column(name = "sku_upc")
	private String skuUpc;

	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	public String getSkuUpc() {
		return skuUpc;
	}
	public void setSkuUpc(String skuUpc) {
		this.skuUpc = skuUpc;
	}
	
	
}
