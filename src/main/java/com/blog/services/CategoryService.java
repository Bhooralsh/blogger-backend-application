package com.blog.services;

import java.util.List;

import com.blog.payload.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto category);
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	CategoryDto getCategoryById(Integer categoryId);
	List<CategoryDto>getAllCategories(); 
	void deletCategory(Integer category);
}
