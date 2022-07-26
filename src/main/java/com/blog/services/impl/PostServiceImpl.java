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
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));

		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newPost = this.postRepositry.save(post);
		return this.modelMapper.map(newPost, PostDto.class);

	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
			Post post=	this.postRepositry.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","Post id",postId));
			post.setTitle(postDto.getTitle());
			post.setContent(postDto.getContent());
			post.setImageName(postDto.getImageName());
			
			Post updatedPost=this.postRepositry.save(post);
			
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		List<Post>allPosts=this.postRepositry.findAll();
		
		Post post=	this.postRepositry.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","Post id",postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		List<Post>allPosts = this.postRepositry.findAll();
		List<PostDto> postDtos=allPosts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());	
		return postDtos;
	
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
		Post post=this.postRepositry.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post id",postId));
			this.postRepositry.delete(post);
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category id ", categoryId));
		List<Post> totalposts = this.postRepositry.findByCategory(cat);

	
		List<PostDto> postDtos = totalposts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
		List<Post> posts = this.postRepositry.findByUser(user);

		List<PostDto> postDto = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDto;
	}

	@Override
	public List<Post> searchPosts(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
