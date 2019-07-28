package com.phutran.services;

import java.util.List;

import com.phutran.entities.Category;
public interface TestService {
	List<Category> removeByNameLike(String name);
	
	Long removeByNameContaining(String name);
}
