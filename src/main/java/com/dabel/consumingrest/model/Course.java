package com.dabel.consumingrest.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Course {
	
	private int id;
	private String title;
	private String description;
	private String category;
	private String level;
	private LocalDateTime postedAt;
}
