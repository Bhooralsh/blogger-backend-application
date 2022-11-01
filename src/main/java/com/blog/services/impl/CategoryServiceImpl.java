package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.entities.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payload.CategoryDto;
import com.blog.payload.UserDto;
import com.blog.repositories.CategoryRepository;
import com.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub

		Category cat = this.modelMapper.map(categoryDto, Category.class);

		Category addCat = this.categoryRepository.save(cat);

		return this.modelMapper.map(addCat, CategoryDto.class);
		/*
		 * Category catgory = this.dtoToCategory(categoryDto); Category savedCategory =
		 * this.categoryRepository.save(catgory); return
		 * this.categoryToDto(savedCategory);
		 */
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId));
		category.setCategoryDescription(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());

		Category updateCategory = this.categoryRepository.save(category);

		return this.modelMapper.map(updateCategory, CategoryDto.class);
		// CategoryDto categoryDto1 = this.categoryToDto(updateCategory);
		// return categoryDto1;
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {

		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

		return this.modelMapper.map(category, CategoryDto.class);

	}

	@Override
	public List<CategoryDto> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> categories = categoryRepository.findAll();

		List<CategoryDto>catDto=categories.stream().map((cat) -> this.modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
		/*
		 * List<CategoryDto> categoryDtos = categories.stream().map(category ->
		 * this.categoryToDto(category)) .collect(Collectors.toList());
		 */
		return catDto;
	}

	@Override
	public void deletCategory(Integer categoryId) {

		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", " category id", categoryId));

		this.categoryRepository.delete(category);
		// TODO Auto-generated method stub

	}

	private Category dtoToCategory(CategoryDto categoryDto) {

		Category category = this.modelMapper.map(categoryDto, Category.class);
		// Use r user = new User();
		// user.setId(userDto.getId());
		// user.setName(userDto.getName());
		// user.setEmail(userDto.getEmail());

		// user.setPassword(userDto.getPassword());
		// user.setAbout(userDto.getAbout());
		return category;

	}

	public CategoryDto categoryToDto(Category category) {

		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
		// UserDto userDto = new UserDto();
		// userDto.setId(user.getId());
		// userDto.setName(user.getName());
		// userDto.setEmail(user.getEmail());

		// userDto.setPassword(user.getPassword());
		// userDto.setAbout(user.getAbout());

		return categoryDto;
	}

}
