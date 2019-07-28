package com.phutran.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phutran.entities.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
	//@Query("SELECT new com.phutran.entities.News(n, c.name AS catName) FROM  News n  INNER JOIN Category c  ON c.id = n.category.id")
	@Query("SELECT new com.phutran.entities.News(n, c.name AS catName) FROM  News n  INNER JOIN Category c  ON c.id = n.category.id")
	List<News> a();
}
