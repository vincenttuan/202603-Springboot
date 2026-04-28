package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.AuthorRepository;

@SpringBootTest
public class Test_ReadAuthor2 {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Test
	public void read() {
		// 顯示作者有哪些書 ?
	}
	
}
