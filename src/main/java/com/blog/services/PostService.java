package com.blog.services;

import java.util.List;

import com.blog.entities.Post;
import com.blog.payload.PostDto;
import com.blog.payload.PostReponse;

public interface PostService {

	//create post
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update post
	public PostDto updatePost(PostDto postDto,Integer postId);
	
	//
	public PostDto getPostById(Integer postId);
	
	
	//get all post
	public PostReponse getAllPost(Integer pageNumber,Integer PageSize,String sortBy,String sortDir);

	//delete 
	public void deletePost(Integer postId);
	
	
	//get All post by category
	List<PostDto>getPostsByCategory(Integer categoryId);
	
	
	//get all posts by user
	List<PostDto> getPostByUser(Integer userId);
	
	//search post
	List<PostDto> searchPosts(String key);
	
}
