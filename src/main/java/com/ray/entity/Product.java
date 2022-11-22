package com.ray.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="product")
@NamedQueries({
	@NamedQuery(name="Product.HQL.getByName", 
		query = "SELECT p FROM Product p where p.name = :name"),
	@NamedQuery(name="Product.HQL.getByNameAndNotProductId", 
		query = "SELECT p FROM Product p where p.name = :name and p.productId != :productId")
})
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="author")
	private String author;
	
	@Column(name="description")
	private String description;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="image")
	private byte[] image;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="publish_date")
	private Date publishDate;
	
	@Column(name="last_update_time")
	@UpdateTimestamp
	private Date lastUpdateTime;
	
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
	
	@Transient
	private String base64Image;

	public Product() {
	}

	public Integer getProductId() {
		return productId;
	}
	
	public String getBase64Image() {
		return Base64.getEncoder().encodeToString(image);
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", author=" + author + ", description="
				+ description + ", isbn=" + isbn + ", image=" + Arrays.toString(image) + ", price=" + price
				+ ", publishDate=" + publishDate + ", lastUpdateTime=" + lastUpdateTime + ", category=" + category
				+ "]";
	}
	
	
}
