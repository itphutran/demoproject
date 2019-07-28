package com.phutran.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "news", catalog = "testsql", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, table = "news", unique = true, nullable = false)
	private Long id;
	@Column(name = "name", length = 150, table = "news", unique = true, nullable = false)
	private String name;
	@ManyToOne
	@ManyToMany
	@JoinColumn(name = "cat_id")
	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Transient
	private String catName;

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public News(News news, String catName) {
		this.id = news.id;
		this.name = news.name;
		this.catName = catName;
	}

	public News() {
		super();
	}

}
