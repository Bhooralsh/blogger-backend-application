package com.blog.services;

import java.util.List;

import com.blog.entities.Post;
import com.blog.payload.PostDto;

public interface PostService {

	//create post
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update post
	public Post updatePost(PostDto postDto,Integer postId);
	
	//
	public Post getPostById(Integer postId);
	//get all post
	public List<Post>getAllPost();

	//delete 
	public void deleteCategory(Integer postId);
	
	
	//get All post by category
	List<Post>getPostsByCategory(Integer categoryId);
	
	
	//get all posts by user
	List<Post> getPostByUser(Integer userId);
	
	//search post
	List<Post> searchPosts(String key);
	
}
