package com.selfLearn.springboot.rest.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selfLearn.springboot.rest.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
