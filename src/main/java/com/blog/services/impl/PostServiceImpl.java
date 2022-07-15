package com.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payload.PostDto;
import com.blog.repositories.CategoryRepository;
import com.blog.repositories.PostRepository;
import com.blog.repositories.UserRepository;
import com.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepositry;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private CategoryRepository categoryRepository;


	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub
		
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","user id",userId));
		
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","category id",categoryId));
		
		
		Post post = this.modelMapper.map(postDto,Post.class);
		post.setImageName("default.png");
		post.setAddDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newPost=this.postRepositry.save(post);
		return this.modelMapper.map(newPost, PostDto .class) ;
		
	}


	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteCategory(Integer postId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Post> getPostsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Post> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Post> searchPosts(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
