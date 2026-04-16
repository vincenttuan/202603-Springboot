package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@SpringBootTest
public class BookRepositoryJdbcTest {
	
	@Autowired
	@Qualifier("bookRepositoryJdbcImpl") // 指定實現類
	private BookRepository bookRepository;
	
	//@Test
	void queryTest() {
		List<Book> books = bookRepository.findAllBooks();
		books.forEach(System.out::println);
	}
	
	//@Test
	void getTest() {
		Optional<Book> optBook = bookRepository.getBookById(1);
		if(optBook.isPresent()) {
			Book book = optBook.get();
			System.out.println(book);
		} else {
			System.out.println("查無資料");
		}
	}
	
	@Test
	void addTest() {
		Book book = new Book(0, "Java", 50.5, 120, true);
		boolean check = bookRepository.addBook(book);
		System.out.println(check ? "新增成功" : "新增失敗");
	}
	
}
