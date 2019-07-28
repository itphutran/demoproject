package com.phutran.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Table(name = "categories", catalog = "testsql", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
@NamedQuery(name = "get_all", query = "FROM Category")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	@OneToMany(mappedBy = "category", fetch=FetchType.LAZY /*,orphanRemoval=true*/, cascade=CascadeType.ALL)
	private List<News> news = new ArrayList<News>();

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

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		/*this.news.clear();
		this.news.addAll(news);*/
		this.news = news;
	}
	/*public void setNews(News news) {
		this.news.add(news);
	}
	public void reNews(News news) {
		this.news.remove(news);
	}*/

	public Category(Long id, String name, List<News> news) {
		super();
		this.id = id;
		this.name = name;
		this.news = news;
	}

	public Category() {
		super();
	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category(Long id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", news=" + news + "]";
	}

}
