package com.phutran.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.phutran.entities.Category;

public interface TestRepository extends CrudRepository<Category, UUID>{
	@Modifying
	@Transactional
	List<Category> removeByNameLike(String name);
	
	@Modifying
	@Transactional
	Long removeByNameContaining(String name);
}
