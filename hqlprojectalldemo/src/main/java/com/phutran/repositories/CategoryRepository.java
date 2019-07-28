package com.phutran.repositories;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phutran.entities.Category;
import com.phutran.entities.News;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category getCategoryById(Long id);
	
	Category findByName(String name);
	
	List<Category> findAllByName(String name);
	
	List<Category> findAllByIdLessThan(Long id);
	
	List<Category> findAllByIdGreaterThanEqual(Long id);
	
	Category findByIdAndName(Long id, String name);
	
	Category findByIdOrName(Long id, String name);
	
	Category findByIdAfter(Long id);

	Category findByIdIsAfter(Long id);
	
	List<Category> findAllByNameContains(String name);
	
	List<Category> findAllByIdGreaterThanEqualAndNameContains(Long id,String name);
	
	List<Category> findAllByIdBetween(Long start, Long end);
	
	List<Category> findAllByIdBetweenAndIdIsNot(Long start, Long end, Long not);
	
	List<Category> findAllByNameEndsWith(String name);
	
	boolean existsById(Long listId);
	
	boolean existsById(List<Long> listId);
	
	boolean existsByIdIn(List<Long> listId);
	
	List<Category> findByNameTrue();
	
	List<Category> findByIdIsAndNewsNotEmpty(Long id);
	
	List<Category> findByNameIsNull();
	
	List<Category> findByNameLike(String name);
	
	//List<Category> findByIdNear();
	
	//List<Category> withinById(Long id);
	@Query("SELECT c FROM Category c")
	List<Category> findTop3();
	
	long count();
	
	List<Category> findByNewsNameAndNewsIdGreaterThanEqual(String name, Long id);
	
	
	Page<Category> findAll(Specification<Category> spec, Pageable pageable);
	
	@Query("SELECT c FROM Category c WHERE c.id =:id")
	Category findByNameAndId(@Param("id") Long id);

}
