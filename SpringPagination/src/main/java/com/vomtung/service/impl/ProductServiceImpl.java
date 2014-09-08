package com.vomtung.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.vomtung.dao.CategoryDAO;
import com.vomtung.dao.ProductDAO;
import com.vomtung.entity.Product;
import com.vomtung.service.ProductService;

@Component
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	/* (non-Javadoc)
	 * @see com.vomtung.service.ProductServicei#getProductDAO()
	 */
	public ProductDAO getProductDAO() {
		return productDAO;
	}

	/* (non-Javadoc)
	 * @see com.vomtung.service.ProductServicei#setProductDAO(com.vomtung.dao.ProductDAO)
	 */
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	/* (non-Javadoc)
	 * @see com.vomtung.service.ProductServicei#findById(long)
	 */
	public Product findById(long id) {
		return this.productDAO.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.vomtung.service.ProductServicei#findAll()
	 */
	public List<Product> findAll() {
		return this.productDAO.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.vomtung.service.ProductServicei#findAll()
	 */
	public List<Product> findAll(int page) {
		return this.productDAO.findAll(page);
	}

	public List<Product> findByCategory(long categoryId){
		return productDAO.findByCategory(categoryId);
	}
	
	public List<Product> findFeaturedProduct(){
		return this.productDAO.findByCategoryName("Featured Products");
	}
	
	public List<Product> findNewProduct(){
		return this.productDAO.findByCategoryName("New Newducts");
	}
	
	public List<Product> findPromotionProduct(){
		return this.productDAO.findByCategoryName("Promotions Products");
	}
	
	public long countAll(){
		return this.productDAO.countAll();
	}
}
