package iss.nus.edu.sg.sa4106.KebunJio.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iss.nus.edu.sg.sa4106.KebunJio.DAO.PostDAO;
import iss.nus.edu.sg.sa4106.KebunJio.Models.Post;
import iss.nus.edu.sg.sa4106.KebunJio.Repository.PostRepository;

/* ToDiscuss:
 * 1. Do we need a interface for all service?
*/
@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	//Function1: CreatePost
	public boolean createPost(PostDAO newPostData) {
		boolean result = false;
		
		Post newPost = new Post();
		// Set the new Post
		newPost.setTitle(newPostData.title);
		newPost.setContent(newPostData.content);
		newPost.setQuestionStatus("Open");
		newPost.setAnswerSolved(false);
		newPost.setPublishedDateTime(LocalDateTime.now());
		
		try {
			postRepository.save(newPost);
			result = true;
		}catch(Exception e) {
			throw new RuntimeException("Created Post Error");
		}
		
		return result;
	}
	
	//Function2: GetAllPosts
	public List<Post> getAllPosts(){
		return postRepository.findAll();
	}
	
	//Function3: GetPostByPostId
	public Post getPostByPostId(String id) {
		Optional<Post> post = postRepository.findById(id);
		if(post.isPresent()) {
			return post.get();
		}else {
			return null;
		}
	}
	//Function4: UpdatePostByPostId
	public boolean UpdatePostByPostId(String id,PostDAO updatePost) {
		boolean result = false;
		// try to find the post
		Optional<Post> post = postRepository.findById(id);
		if(post.isPresent()) {
			Post newPost = post.get();
			newPost.setTitle(updatePost.title);
			newPost.setContent(updatePost.content);
			try {
				postRepository.save(newPost);
				result = true;
			}catch(Exception e) {
				throw new RuntimeException("Update Post Error");
			}
		}
		
		return result;
	}
	
	
	//Function for Junit and GithubActions
	public int add(int a,int b) {
		return a+b;
	}
}
