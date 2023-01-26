package com.selfLearn.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Courses> retrieveAllCourses(){
		return Arrays.asList(new Courses(1, "SpringBoot","in28Mins"),
				new Courses(2, "AWS","in28Mins"),
				new Courses(3, "MicroServices","in28Mins"),
				new Courses(4, "Azure","in28Mins"));
	}
}
