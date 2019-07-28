package com.phutran.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.phutran.entities.Category;
import com.phutran.entities.News;
import com.phutran.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		return categoryRepository.getCategoryById(id);
	}

	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}

	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}

	public List<Category> findAllByName(String name) {
		return categoryRepository.findAllByName(name);
	}

	public List<Category> findAllByIdLessThan(Long id) {
		return categoryRepository.findAllByIdLessThan(id);
	}

	public List<Category> findAllByIdGreaterThanEqual(Long id) {
		return categoryRepository.findAllByIdGreaterThanEqual(id);
	}

	public Category findByIdAndName(Long id, String name) {
		return categoryRepository.findByIdAndName(id, name);
	}

	public Category findByIdOrName(Long id, String name) {
		return categoryRepository.findByIdOrName(id, name);
	}

	public Category findByIdAfter(Long id) {
		return categoryRepository.findByIdAfter(id);
	}

	public Category findByIdIsAfter(Long id) {
		return categoryRepository.findByIdIsAfter(id);
	}

	public List<Category> findAllByNameContains(String name) {
		return categoryRepository.findAllByNameContains(name);
	}

	public List<Category> findAllByIdGreaterThanEqualAndNameContains(Long id, String name) {
		return categoryRepository.findAllByIdGreaterThanEqualAndNameContains(id, name);
	}

	public List<Category> findAllByIdBetween(Long start, Long end) {
		return categoryRepository.findAllByIdBetween(start, end);
	}

	public List<Category> findAllByIdBetweenAndIdIsNot(Long start, Long end, Long not) {
		return categoryRepository.findAllByIdBetweenAndIdIsNot(start, end, not);
	}

	public List<Category> findAllByNameEndsWith(String name) {
		return categoryRepository.findAllByNameEndsWith(name);
	}

	public boolean existsById(Long listId) {
		return categoryRepository.existsById(listId);
	}

	public boolean existsByIdIn(List<Long> listId) {
		return categoryRepository.existsByIdIn(listId);
	}

	public List<Category> findByNameTrue() {
		return categoryRepository.findByNameTrue();
	}

	public List<Category> findByIdIsAndNewsNotEmpty(Long id) {
		return categoryRepository.findByIdIsAndNewsNotEmpty(id);
	}

	public List<Category> findByNameIsNull() {
		return categoryRepository.findByNameIsNull();
	}
	
	public List<Category> findByNameLike(String name) {
		return categoryRepository.findByNameLike(name);
	}

	public List<Category> findTop3() {
		return categoryRepository.findTop3();
	}

	//public List<Category> findByNameNear() {
///		//return categoryRepository.findByNameNear();
	//}
//	public List<Category> withinById(Long id) {
//		return categoryRepository.withinById(id);
//	}
	
	public Long count() {
		return categoryRepository.count();
	}

	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	/*public List<Category> findByNewsName(String name) {
		return categoryRepository.findByNewsName(name );
	}*/

	public List<Category> findByNewsNameAndNewsIdGreaterThanEqual(String name, Long id) {
		return categoryRepository.findByNewsNameAndNewsIdGreaterThanEqual(name, id);
	}

	public Page<Category> findAll(Specification<Category> spec, Pageable pageable) {
		return categoryRepository.findAll(spec, pageable);
	}

	public Category findByNameAndId(Long id) {
		return categoryRepository.findByNameAndId(id);
	}

	/*public List<Category> findAllCategoryAndNewsName() {
		return categoryRepository.findAllCategoryAndNewsName();
	}*/
}
