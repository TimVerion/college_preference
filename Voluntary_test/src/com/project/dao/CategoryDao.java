package com.project.dao;

import java.util.List;

import com.project.domain.Category;

public interface CategoryDao {

	List<Category> findAll() throws Exception;

	void save(Category c) throws Exception;

}
