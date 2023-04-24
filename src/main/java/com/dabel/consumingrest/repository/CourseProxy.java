package com.dabel.consumingrest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.dabel.consumingrest.config.CustomProperties;
import com.dabel.consumingrest.model.Course;

@Repository
public class CourseProxy {

	@Autowired
	CustomProperties customProperties;
	
	public List<Course> findAllCourses() {
		
		String url = customProperties.getApiUrl();
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<Course>> responseEntity = restTemplate.exchange(
				url,
				HttpMethod.GET,
				HttpEntity.EMPTY,
				new ParameterizedTypeReference<List<Course>>() {}
		);
		
		return responseEntity.getBody();
	}
	
	public ResponseEntity<Course> findCourseById(int id) {
		
		String url = customProperties.getApiUrl().concat("/" + id);
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			ResponseEntity<Course> responseEntity = restTemplate.exchange(
					url,
					HttpMethod.GET,
					HttpEntity.EMPTY,
					Course.class
			);
			
			return responseEntity;
			
		} catch (Exception e) {
			
			return ResponseEntity.notFound().build();
		}
		
	}
	
	public Course saveCourse(Course course) {
		
		String url = customProperties.getApiUrl();
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<Course> httpEntity = new HttpEntity<>(course);
		ResponseEntity<Course> responseEntity = restTemplate.exchange(
				url,
				HttpMethod.POST,
				httpEntity,
				Course.class
		);
		
		return responseEntity.getBody();
	}
	
	/**
	 * Indicate updating an existing course
	 * 
	 * @param course
	 * @param updating
	 * @return
	 */
	public Course saveCourse(Course course, boolean updating) {
		
		String url = customProperties.getApiUrl().concat("/" + course.getId());
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<Course> httpEntity = new HttpEntity<>(course);
		ResponseEntity<Course> responseEntity = restTemplate.exchange(
				url,
				HttpMethod.PUT,
				httpEntity,
				Course.class
		);
		
		return responseEntity.getBody();
	}
	
	public Void deleteCourse(int id) {
		
		String url = customProperties.getApiUrl().concat("/" + id);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Void> responseEntity = restTemplate.exchange(
				url,
				HttpMethod.DELETE,
				HttpEntity.EMPTY,
				Void.class
		);
		
		return responseEntity.getBody();
	}
	
}
