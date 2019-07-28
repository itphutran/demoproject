package com.phutran.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phutran.entities.Category;
import com.phutran.entities.News;
import com.phutran.repositories.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsRepository newsRepository;

	public List<News> a() {
		return newsRepository.a();
	}

}
