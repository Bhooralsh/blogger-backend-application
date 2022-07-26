package com.blog.payload;

import java.util.Date;

import com.blog.entities.Category;
import com.blog.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDto {

	private int postId;

	private String title;
	private String content;
	private String imageName;
	private Date addDate;

	private CategoryDto category;

	private UserDto user;
}
