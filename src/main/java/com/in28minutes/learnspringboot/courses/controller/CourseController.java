package com.in28minutes.learnspringboot.courses.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.learnspringboot.courses.bean.Course;

@RestController
public class CourseController {
	//localhost:9090/courses
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return Arrays.asList(new Course(1, "Learn Microservices", "Marco Carrillo"),
				new Course(2, "Fullstack React", "i28Minutes"));
	}
	
	//localhost:9090/courses/1
	@GetMapping("/courses/1")
	public Course getCourseDetails() {
		return new Course(1, "Learn Microservices with spring", "Marco Carrillo");
	}
}
