package com.phutran.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phutran.entities.Category;
import com.phutran.services.CategoryService;
import com.phutran.services.NewsService;
import com.phutran.services.TestService;

@Controller
@RequestMapping("test")
public class TestController {
	@Autowired
	private TestService testService;
	
	@GetMapping("{name}")
	public String index(@PathVariable String name) {
		List<Category> removeByNameLike = testService.removeByNameLike(name);
		System.out.println(removeByNameLike.size());
		return "public/index";
	}
	
	@GetMapping("test02/{name}")
	public String removeByNameContaining(@PathVariable String name) {
		Long removeByNameLike = testService.removeByNameContaining(name);
		System.out.println(removeByNameLike);
		return "public/index";
	}

	
	
}
