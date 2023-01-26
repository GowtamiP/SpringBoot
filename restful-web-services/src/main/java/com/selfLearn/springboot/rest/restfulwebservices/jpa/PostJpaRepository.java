package com.selfLearn.springboot.rest.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selfLearn.springboot.rest.restfulwebservices.user.Post;

public interface PostJpaRepository extends JpaRepository<Post, Integer>{
	
	//Post findByUserIdAndPostId(int id,int postId);

}
