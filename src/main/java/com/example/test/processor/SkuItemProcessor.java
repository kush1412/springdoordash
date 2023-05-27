package com.example.test.processor;

import org.springframework.batch.item.ItemProcessor;

import com.example.test.model.Sku;

public class SkuItemProcessor implements ItemProcessor<Sku,Sku> {

	@Override
	public Sku process(Sku item) throws Exception {
		System.out.println("sku item==>skuid"+item.getSkuId());
		System.out.println("sku item==>upc"+item.getSkuUpc());
		System.out.println("Inside SkuItemProcessor method starttedd");
		return item;
	}

}