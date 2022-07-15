package com.blog.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {

	private int categoryId;
	
	@NotBlank
	@Size(min=4,message="Min size category title is 4")
	private String categoryTitle;
	@NotBlank
	@Size(max=10,message="min size of category desc is 10 ")
	private String categoryDescription;
	
}
