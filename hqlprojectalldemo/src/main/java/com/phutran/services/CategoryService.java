package com.phutran.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.phutran.entities.Category;
import com.phutran.entities.News;
public interface CategoryService {
	List<Category> findAll();

	Category findById(Long catId);

	Category save(Category category);

	void delete(Long catId);
	
	Category findByName(String name);
	
	List<Category> findAllByName(String name);
	
	List<Category> findAllByIdLessThan(Long id);
	
	List<Category> findAllByIdGreaterThanEqual(Long id);
	
	Category findByIdAndName(Long id, String name);
	
	Category findByIdOrName(Long id, String name);
	
	Category findByIdAfter(Long id);
	
	Category findByIdIsAfter(Long id);
	
	List<Category> findAllByNameContains(String name);
	
	List<Category> findAllByIdGreaterThanEqualAndNameContains(Long id, String name);
	
	List<Category> findAllByIdBetween(Long start, Long end);
	
	List<Category> findAllByIdBetweenAndIdIsNot(Long start, Long end, Long not);
	
	List<Category> findAllByNameEndsWith(String name);
	
	boolean existsById(Long listId);
	
	boolean existsByIdIn(List<Long> listId);
	
	List<Category> findByNameTrue();
	
	List<Category> findByIdIsAndNewsNotEmpty(Long id);
	
	List<Category> findByNameIsNull();
	
	List<Category> findByNameLike(String name);
	
	//List<Category> findByNameNear();
	
	//List<Category> withinById(Long id);
	
	List<Category> findTop3();
	
	Long count();
	
	Page<Category> findAll(Pageable pageable);
	
	List<Category> findByNewsNameAndNewsIdGreaterThanEqual(String name, Long id);
	
	Page<Category> findAll(Specification<Category> spec, Pageable pageable);
	
	Category findByNameAndId(Long id);
	
	/*List<Category> findAllCategoryAndNewsName();*/
}
