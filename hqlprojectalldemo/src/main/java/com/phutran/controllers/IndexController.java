package com.phutran.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.phutran.entities.Category;
import com.phutran.entities.News;
import com.phutran.repositories.CategoryRepository;
import com.phutran.services.CategoryService;
import com.phutran.services.NewsService;

@Controller
public class IndexController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private NewsService newsService;
	
	@GetMapping
	public String index() {
		return "public/index";
	}

	@GetMapping("add/{name}")
	public String addItem(@PathVariable String name) {
		Category categorySave = categoryService.save(new Category(name));
		System.out.println(categorySave.getName());
		return "public/index";
	}

	@GetMapping("update/{id}/{name}")
	public String update(@PathVariable Long id, @PathVariable String name) {
		// Category save = categoryService.findById(id);
		// save.setName(name);
		// save= categoryService.save(save);
		// System.out.println(save.getName());

		/*
		 * Category category = new Category(); category.setId(id);
		 * category.setName(name); Category save = categoryService.save(category);
		 */
		Category save = categoryService.save(new Category(id, name));
		return "public/index";
	}

	@GetMapping("get/{id}")
	public String getItem(@PathVariable Long id) {
		Category findByCatId = categoryService.findById(id);
		/*
		 * List<News> news = findByCatId.getNews(); for (News news2 : news) {
		 * System.out.println(news2.getName()); }
		 */
		System.out.println(findByCatId.getName());
		return "public/index";
	}

	@GetMapping("getAll")
	public String getAll() {

		List<Category> findAll = categoryService.findAll();
		for (Category category : findAll) {
			System.out.println(category.getName());
		}
		return "public/index";
	}

	@GetMapping("del/{id}")
	public String del(@PathVariable Long id) {
		categoryService.delete(id);
		return "public/index";
	}

	@GetMapping("findName/{name}")
	public String findByName(@PathVariable String name) {
		Category findByName = categoryService.findByName(null);
		System.out.println(findByName.getName());
		return "public/index";
	}

	@GetMapping("findAllName/{name}")
	public String findAllByName(@PathVariable String name) {
		List<Category> findAllByName = categoryService.findAllByName(name);
		for (Category category : findAllByName) {
			System.out.println(category.getName() + "__" + category.getId());
		}
		return "public/index";
	}

	@GetMapping("findAllLessThanById/{id}")
	public String findAllByName(@PathVariable Long id) {
		List<Category> findAllByName = categoryService.findAllByIdLessThan(id);
		for (Category category : findAllByName) {
			System.out.println(category.getName() + "__" + category.getId());
		}
		return "public/index";
	}

	@GetMapping("findAllByIdGreaterThanEqual/{id}")
	public String findAllByIdGreaterThanEqual(@PathVariable Long id) {
		List<Category> findAllByName = categoryService.findAllByIdGreaterThanEqual(id);
		System.out.println("findAllByIdGreaterThanEqual---------");
		for (Category category : findAllByName) {
			System.out.println(category.getName() + "__" + category.getId());
		}
		return "public/index";
	}

	@GetMapping("findByIdAndName/{id}/{name}")
	public String findByIdAndName(@PathVariable Long id, @PathVariable String name) {
		Category findByIdAndName = categoryService.findByIdAndName(id, name);
		System.out.println("findByIdAndName---------");
		System.out.println(findByIdAndName.getName() + "--" + findByIdAndName.getId());
		return "public/index";
	}

	@GetMapping("findByIdOrName/{id}/{name}")
	public String findByIdOrName(@PathVariable Long id, @PathVariable String name) {
		Category findByIdOrName = categoryService.findByIdOrName(id, name);
		System.out.println("findByIdOrName---------");
		System.out.println(findByIdOrName.getName() + "--" + findByIdOrName.getId());
		return "public/index";
	}

	@GetMapping("findByIdAfter/{id}")
	public String findByIdAfter(@PathVariable Long id) {
		Category findByIdAfter = categoryService.findByIdAfter(id);
		System.out.println("findByIdAfter---------");
		System.out.println(findByIdAfter.getName() + "--" + findByIdAfter.getId());
		return "public/index";
	}

	@GetMapping("findByIdIsAfter/{id}")
	public String findByIdIsAfter(@PathVariable Long id) {
		Category findByIdIsAfter = categoryService.findByIdIsAfter(id);
		System.out.println("findByIdIsAfter---------");
		System.out.println(findByIdIsAfter.getName() + "--" + findByIdIsAfter.getId());
		return "public/index";
	}

	@GetMapping("findAllByIdContains/{name}")
	public String findAllByNameContains(@PathVariable String name) {
		System.out.println("findAllByNameContains:");
		List<Category> findAllByIdContains = categoryService.findAllByNameContains(name);
		for (Category category : findAllByIdContains) {
			System.out.println(category.getName() + "--" + category.getId());
		}
		return "public/index";
	}

	@GetMapping("findAllByIdGreaterThanEqualAndNameContains/{id}/{name}")
	public String findAllByIdGreaterThanEqualAndNameContains(@PathVariable Long id, @PathVariable String name) {
		System.out.println("findAllByNameContainsAndByIdGreaterThanEqual:");
		List<Category> findAllByNameContainsAndByIdGreaterThanEqual = categoryService
				.findAllByIdGreaterThanEqualAndNameContains(id, name);
		for (Category category : findAllByNameContainsAndByIdGreaterThanEqual) {
			System.out.println(category.getName() + "--" + category.getId());
		}
		return "public/index";
	}

	@GetMapping("findAllByIdBetween/{start}/{end}")
	public String findAllByIdBetween(@PathVariable Long start, @PathVariable Long end) {
		System.out.println("findAllByIdBetween:");
		List<Category> findAllByIdBetween = categoryService.findAllByIdBetween(start, end);
		for (Category category : findAllByIdBetween) {
			System.out.println(category.getName() + "--" + category.getId());
		}
		return "public/index";
	}

	@GetMapping("findAllByIdBetweenAndIdIsNot/{start}/{end}/{not}")
	public String findAllByIdBetweenAndIdIsNot(@PathVariable Long start, @PathVariable Long end,
			@PathVariable Long not) {
		System.out.println("findAllByIdBetweenAndIdIsNot:>>>>>>>>>>>>>>>>>>>>>");
		List<Category> findAllByIdBetweenAndIdIsNot = categoryService.findAllByIdBetweenAndIdIsNot(start, end, not);
		for (Category category : findAllByIdBetweenAndIdIsNot) {
			System.out.println(category.getName() + "--" + category.getId());
		}
		return "public/index";
	}

	@GetMapping("findAllByNameEndsWith/{name}")
	public String findAllByNameEndsWith(@PathVariable String name) {
		System.out.println("findAllByNameEndsWith:>>>>>>>>>>>>>>>>>>>>>");
		List<Category> findAllByNameEndsWith = categoryService.findAllByNameEndsWith(name);
		for (Category category : findAllByNameEndsWith) {
			System.out.println(category.getName() + "--" + category.getId());
		}
		return "public/index";
	}

	@GetMapping("existsById")
	public String findAllByIdExists() {
		System.out.println("existsById:>>>>>>>>>>>>>>>>>>>>>");
		boolean findAllByIdExists = categoryService.existsById(21l);
		System.out.println(findAllByIdExists);
		return "public/index";
	}

	@GetMapping("existsByIdIn")
	public String existsByIdIn() {
		System.out.println("existsByIdIn:>>>>>>>>>>>>>>>>>>>>>");
		List<Long> listInt = new ArrayList<Long>();
		listInt.add(2l);
		listInt.add(122l);
		listInt.add(210l);
		boolean findAllByIdExists = categoryService.existsByIdIn(listInt);
		System.out.println(findAllByIdExists);
		return "public/index";
	}

	@GetMapping("findByNameTrue")
	public String findByNameTrue() {
		System.out.println("findByNameTrue:>>>>>>>>>>>>>>>>>>>>>findByNameTrue");
		List<Category> findByNameTrue = categoryService.findByNameTrue();
		for (Category category : findByNameTrue) {
			System.out.println(category.getName());
		}
		return "public/index";
	}
	
	@GetMapping("findByIdIsAndNameNotEmpty/{id}")
	public String findByIdIsAndNewsNotEmpty(@PathVariable Long id) {
		System.out.println("findByIdIsAndNewsNotEmpty:>>>>>>>>>>>>>>>>>>>>>findByIdIsAndNewsNotEmpty");
		List<Category> findByIdIsAndNewsNotEmpty = categoryService.findByIdIsAndNewsNotEmpty(id);
		for (Category category : findByIdIsAndNewsNotEmpty) {
			System.out.println(category.getName());
		}
		return "public/index";
	}
	
	@GetMapping("findByNameIsNull")
	public String findByNameIsNull() {
		System.out.println("findByNameIsNull:>>>>>>>>>>>>>>>>>>>>>findByNameIsNull");
		List<Category> findByNameIsNull = categoryService.findByNameIsNull();
		for (Category category : findByNameIsNull) {
			System.out.println(category.getName() + "--"+category.getId());
		}
		return "public/index";
	}
	
	@GetMapping("findByNameLike/{name}")
	public String findByNameLike(@PathVariable String name) {
		System.out.println("findByNameLike:>>>>>>>>>>>>>>>>>>>>>findByNameLike");
		List<Category> findByNameLike = categoryService.findByNameLike(name);
		for (Category category : findByNameLike) {
			System.out.println(category.getName() + "--"+category.getId());
		}
		return "public/index";
	}
	
	/*@GetMapping("WithinById/{id}")
	public String findByNameNear(@PathVariable Long id) {
		System.out.println("WithinById:>>>>>>>>>>>>>>>>>>>>>WithinById");
		List<Category> findByIdWithin = categoryService.withinById(id);
		for (Category category : findByIdWithin) {
			System.out.println(category.getName() + "--"+category.getId());
		}
		return "public/index";
	}*/
	
	@GetMapping("findAllByIdTop3")
	public String findAllByIdTop3() {
		System.out.println("findAllByIdTop3:>>>>>>>>>>>>>>>>>>>>>findAllByIdTop3");
		List<Category> findAllByIdTop3 = categoryService.findTop3();
		for (Category category : findAllByIdTop3) {
			System.out.println(category.getName() + "--"+category.getId());
		}
		return "public/index";
	}
	
	@GetMapping("countAll")
	public String countAll() {
		System.out.println("countAll:>>>>>>>>>>>>>>>>>>>>>countAll");
		Long countAll = categoryService.count();
		System.out.println(countAll);
		return "public/index";
	}

	@GetMapping("findAllPagination/{page}")
	public String findAllPagination(@PathVariable Integer page) {
		System.out.println("-------------------------------------");
		List<Category> findAll = categoryService.findAll(PageRequest.of(page, 10)).getContent();
		System.out.println(findAll.size());
		return "public/index";
	}
	
	@GetMapping("find01")
	public String find01() {
		System.out.println("-------------------------------------");
		List<Category> findAll = categoryService.findByNewsNameAndNewsIdGreaterThanEqual("x", 5l);
		System.out.println(findAll.size());
		return "public/index";
	}
	
	@GetMapping("find02")
	public String find02() {
		System.out.println("------------------find02-------------------");
		Category category = new  Category();
		category.setId(1L);
		category.setName("X");
		//List<Category> findAll = categoryService.findAll(category, PageRequest.of(1, 5));
		//System.out.println(findAll.size());
		return "public/index";
	}
	
	@GetMapping("findByNameAndId/{id}")
	public String findByNameAndId(@PathVariable Long id) {
		System.out.println("------------------findByNameAndId-------------------");
		Category findByNameAndId = categoryService.findByNameAndId(id);
		System.out.println(findByNameAndId.getName());
		return "public/index";
	}
	
	@GetMapping("findNewsAndCatName")
	public String findNewsAndCatName() {
		System.out.println("------------------findNewsAndCatName-------------------");
		List<News> findAllCategoryAndNewsName = newsService.a();
		for (News news : findAllCategoryAndNewsName) {
			System.out.println(news.getCatName() );
		}
		return "public/index";
	}
	
	
	
	
}
