package com.blog.services;

import java.util.List;

import com.blog.entities.Post;
import com.blog.payload.PostDto;

public interface PostService {

	//create post
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update post
	public PostDto updatePost(PostDto postDto,Integer postId);
	
	//
	public PostDto getPostById(Integer postId);
	
	
	//get all post
	public List<PostDto>getAllPost();

	//delete 
	public void deletePost(Integer postId);
	
	
	//get All post by category
	List<PostDto>getPostsByCategory(Integer categoryId);
	
	
	//get all posts by user
	List<PostDto> getPostByUser(Integer userId);
	
	//search post
	List<Post> searchPosts(String key);
	
}
