package com.selfLearn.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.selfLearn.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	//@Autowired
	//private CourseJdbcRepository courseRespository;
	
	//@Autowired
	//private CourseJpaRepository courseRepository;
	
	@Autowired
	private CourseSpringDataJpaRepository courseRepository;
	
	@Override
	public void run(String... args) throws Exception {
		courseRepository.save(new Course(1l,"AWS","in28mins"));
		courseRepository.save(new Course(2l,"Search","in28mins"));
		courseRepository.save(new Course(3l,"Microservices","in28mins"));
		courseRepository.save(new Course(4l,"WCS","in28mins"));
		courseRepository.deleteById(4l);
		System.out.println(courseRepository.findById(2l));
		System.out.println(courseRepository.findById(3l));
		
		System.out.println(courseRepository.findAll());
		System.out.println(courseRepository.findByAuthor("in28mins"));
		
		System.out.println(courseRepository.findByName("Search"));
	}

}
