package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@ManyToMany
	@JoinTable(
			name = "publisher_storybook", // 中間表的名稱
			joinColumns = @JoinColumn(name = "publisher_id"),
			inverseJoinColumns = @JoinColumn(name = "storybook_id")
	)
	private List<StoryBook> storyBooks;
	
}
