package com.vomtung.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vomtung.dao.ProductDAO;
import com.vomtung.entity.Product;

public interface ProductService {

	public ProductDAO getProductDAO();

	public void setProductDAO(ProductDAO productDAO);

	public Product findById(long id);

	public List<Product> findAll();
	
	public List<Product> findAll(int page);
	
	public List<Product> findByCategory(long categoryId);
	
	public List<Product> findFeaturedProduct();
	
	public List<Product> findNewProduct();
	
	public List<Product> findPromotionProduct();
	
	public long countAll();

}