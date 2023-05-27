package com.example.test.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.Sku;
import com.example.test.respository.SkuRepository;

@RestController
public class SkuService {
	@Autowired
	SkuRepository skuRepo;
	@GetMapping("/getsku")
	public ResponseEntity<List<Sku>> getSkus(){
		//List<Sku> lsit=skuRepo.findAll();
		//System.out.println("List==>"+lsit);
		//return new ResponseEntity<>(lsit,HttpStatus.OK);
		return null;
	}
	
	@GetMapping("/getskupage")
	public ResponseEntity<Page<List<Sku>>> getSkusPage(){
		Pageable pg= getPagable(1);
		
		Page<List<Sku>> lsit=skuRepo.findBySku(pg);
		System.out.println("List==>"+lsit);
		return new ResponseEntity<>(lsit,HttpStatus.OK);
	}
	
	public Pageable getPagable(Integer pageNo) {

		if (null == pageNo || pageNo <= 0) {
			pageNo = 0;
		} else {
			pageNo = pageNo - 1;
		}

		//Integer defaultLimitSize = NumberUtils.toInt(limit,100);
		return PageRequest.of(pageNo, 100);
	}

}
