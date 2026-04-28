package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@SpringBootTest
public class Test_ReadAuthor2 {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Test
	public void read() {
		// 顯示作者有出版幾本書 ?
		List<Author> authors = authorRepository.findAll();
		
		
		authors.forEach(au -> {
			System.out.printf("作者: %s 書籍數量: %d%n", au.getName(), au.getStoryBooks().size());
		});
		
	}
	
}
