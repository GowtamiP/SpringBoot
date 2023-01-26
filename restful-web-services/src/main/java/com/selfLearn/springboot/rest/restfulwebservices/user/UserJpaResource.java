package com.selfLearn.springboot.rest.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.selfLearn.springboot.rest.restfulwebservices.jpa.PostJpaRepository;
import com.selfLearn.springboot.rest.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostJpaRepository postRepository;
	
	public  UserJpaResource(UserRepository userRepository,PostJpaRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}
	
	@GetMapping(path="/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
		
	}
	
	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		Optional<User> user = userRepository.findById(id);
		//User user = service.findUser(id);
		if(user.isEmpty())
			throw new UserNotFoundException("id: "+ id);
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
		
	}
	
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		
		User savedUser = userRepository.save(user);
		// location - /jpa/users/4 --> /jpa/users/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		userRepository.deleteById(id);
	}
	
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id){
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("id: "+ id);
		return user.get().getPosts();
		
	}
	
	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<User> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("id: "+ id);
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);
		// location - /jpa/users/4 --> /jpa/users/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "/jpa/users/{id}/posts/{postId}")
	public Post retrievePostsForUser(@PathVariable int id,@PathVariable int postId){
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("id: "+ id);
		return postRepository.findById(postId).get();
		
	}
	
	

}
