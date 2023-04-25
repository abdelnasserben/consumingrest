package com.dabel.consumingrest.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dabel.consumingrest.model.Course;
import com.dabel.consumingrest.repository.CourseProxy;

/**
 * Service class
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@Service
public class CourseService {

	private CourseProxy courseRepository;

	public CourseService(CourseProxy courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	
	public List<Course> findAll() {
		
		return courseRepository.findAllCourses();
	}
	
	public Course findById(int id) {
		
		ResponseEntity<Course> response = courseRepository.findCourseById(id);
		
		return response.getBody();
	}
	
	
	/**
	 * Save or create a course
	 * 
	 * @param course
	 * @param updating
	 * @return
	 */
	public Course save(Course course, boolean updating) {
		
		if(updating == true)
			return courseRepository.saveCourse(course, true);
		
		return courseRepository.saveCourse(course);
	}
	
	public Void deleteById(int id) {
		
		return courseRepository.deleteCourse(id);
	}
	
	public boolean exists(int id) {
		
		ResponseEntity<Course> response = courseRepository.findCourseById(id);
		return !response.getStatusCode().equals(HttpStatus.NOT_FOUND);
	}
}
