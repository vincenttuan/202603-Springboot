package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.PublisherRepository;

@SpringBootTest
public class Test_DeletePublisherStorybook {
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	@Test
	public void delete() {
		
		publisherRepository.deleteStoryBookFromPublisher(1, 1);
		System.out.println("Delete OK");
	}
	
}
