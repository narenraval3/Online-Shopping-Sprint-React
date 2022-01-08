package com.onlineshopping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onlineshopping.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM produt_details p WHERE p.prodName LIKE %?1%")
	public List<Product> searchByName(String prodName);

	@Modifying
	@Query("update produt_details p set p.prodName= ?1 where p.prodName= ?2")
	public String updateByName(String prodName);
	
	@Modifying
	@Query("DELETE produt_details c WHERE c.prodName= ?1")
	void deleteByName(@Param("prodName") String prodName);
	
	@Query("SELECT p FROM produt_details p WHERE p.prodName LIKE %?1%")
	public Product searchByProdName(String prodName);

}
