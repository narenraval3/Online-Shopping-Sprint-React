package com.onlineshopping.service;

import java.util.List;

import com.onlineshopping.entity.Product;

public interface ProductService {
	public Product addProduct(Product product);
	public void deleteProduct(String prodName);
	public Product getProdById(Integer prodId);
	public List<Product> getAllProduct();
	public List<Product> findByName(String prodName);
	public Product updateProduct(Product product);
	
	

}
