package com.vomtung.dao;

import javax.persistence.*;

import java.util.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.*;

import com.vomtung.entity.Product;

@Repository("ProductDAO")
@Transactional
public class ProductDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void create(Product product) {
		entityManager.persist(product);
	}

	public void delete(Product product) {
		entityManager.remove(entityManager.merge(product));
	}

	public void edit(Product product) {
		entityManager.merge(product);
	}

	public List<Product> findByOwner(Long ownerId) {
		Query query = entityManager.createQuery("select pd from Product pd WHERE pd.owner.id=:ownerId",Product.class);
		query.setParameter("ownerId", ownerId);
		return query.getResultList();
	}
	
	public Product findById(Long id) {
		return entityManager.find(Product.class, id);
	}

	public List<Product> findAll(int page) {
		Query query = entityManager.createQuery("select pd from Product pd",Product.class);
		query.setFirstResult((page-1) * 3).setMaxResults(3);
		return query.getResultList();
	}
	
	public List<Product> findAll() {
		Query query = entityManager.createQuery("select pd from Product pd",Product.class);
		return query.getResultList();
	}

	public List<Product> findByCategory(long categoryId) {
		Query query = entityManager.createQuery("select pd from Product pd where pd.category.id=:categoryId",Product.class);
		query.setParameter("categoryId", categoryId);
		return query.getResultList();
	}
	
	public List<Product> findByCategoryName(String categoryName) {
		Query query = entityManager.createQuery("select pd from Product pd where pd.category.categoryName IS :categoryName",Product.class);
		query.setParameter("categoryName", categoryName);
		return query.getResultList();
	}
	
	public long countAll() {
		Query query = entityManager.createQuery("SELECT COUNT(pd) from Product as pd");
		long count = (Long)query.getSingleResult();
		return count;
	}
	
}
