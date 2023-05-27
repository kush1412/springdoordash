package com.example.test.respository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.Sku;

@Repository
public interface SkuRepository extends PagingAndSortingRepository<Sku, Long> {
	
	@Query(value = "SELECT * from skus", nativeQuery = true)
	Page <List<Sku>> findByAll(Pageable pageable);
	
	@Query(value = "SELECT * from skus", nativeQuery = true)
	public Page<List<Sku>>findBySku(Pageable pageable);
}
