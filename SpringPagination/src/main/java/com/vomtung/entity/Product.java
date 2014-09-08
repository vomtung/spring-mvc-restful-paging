package com.vomtung.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import flexjson.JSONSerializer;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	@NotNull
	@NotEmpty
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="manufacture")
	private String manufacture;
	
	@Column(name="price")
	private long price;
	
	@Column(name="image_name")
	private String imageName;

	@ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id", nullable = false)
	Category category;
	
	@Transient
	long totalProduct=0;
	
	public Product() {
		super();
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacture() {
		return manufacture;
	}
	
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}

    public long getTotalProduct() {
    	if(this.totalProduct==0){
    		
    	}
		return totalProduct;
	}

	public void setTotalProduct(long totalProduct) {
		this.totalProduct = totalProduct;
	}

	public static String serialize(Product product) {
    	JSONSerializer serialiser = new JSONSerializer();
        return serialiser.serialize(product);
    }

    public static String toJsonArray(Collection<Product> collection) {
    	JSONSerializer serialiser = new JSONSerializer();
        return serialiser.serialize(collection);
    }
	
}
