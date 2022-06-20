package com.in28minutes.learnspringboot.courses.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.learnspringboot.courses.bean.Course;
import com.in28minutes.learnspringboot.courses.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository repository;
	
	//localhost:9090/courses
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		//return Arrays.asList(new Course(1, "Learn Microservices", "Marco Carrillo"),
			//	new Course(2, "Fullstack React", "i28Minutes"));
		
		return repository.findAll();
	}
	
	//localhost:9090/courses/1
	@GetMapping("/courses/{id}")
	public Course getCourseDetails(@PathVariable long id) {
		Optional<Course> course = repository.findById(id);
		if(course.isEmpty()) {
			throw new RuntimeException("Course not found with id: " + id);
		}
		return course.get();
	}
}
