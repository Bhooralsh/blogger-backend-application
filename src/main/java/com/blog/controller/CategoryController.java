package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payload.ApiResponse;
import com.blog.payload.CategoryDto;
import com.blog.payload.UserDto;
import com.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
		CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);
	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,
			@PathVariable("categoryId") Integer cId) {
		CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, cId);
		return ResponseEntity.ok(updateCategory);
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer categoryId) {

		return ResponseEntity.ok(this.categoryService.getCategoryById(categoryId));
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories() {
		return ResponseEntity.ok(this.categoryService.getAllCategories());
	}
	

	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("categoryId") Integer categoryId) {

		this.categoryService.deletCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully", true), HttpStatus.OK);
		// return new ResponseEntity(Map.of("message","User deleted
		// Succcessfully"),HttpStatus.OK);
	}

}
