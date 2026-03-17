package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository // 專門負責 "資料存取" 的元件, Spring 會自動建立該物件並管理
public class BookRepositoryImpl implements BookRepository {
	// InMemory 版
	private List<Book> books = new CopyOnWriteArrayList<>();
	
	// 初始資料有 4 本書
	{
		books.add(new Book(1, "小叮噹", 12.5, 20, true));
		books.add(new Book(2, "老夫子", 10.5, 30, true));
		books.add(new Book(3, "好小子", 9.5, 40, true));
		books.add(new Book(4, "新樂園", 14.5, 50, false));
	}
	
	@Override
	public List<Book> findAllBooks() {
		return books;
	}

	@Override
	public Optional<Book> getBookById(Integer id) {
		return books.stream().filter(book -> book.getId().equals(id)).findFirst();
	}

	@Override
	public boolean addBook(Book book) {
		// 建立 newId
		OptionalInt optMaxId = books.stream().mapToInt(Book::getId).max(); // 取出目前 books 中 id 的最大值
		int newId = optMaxId.isEmpty() ? 1 : optMaxId.getAsInt() + 1;
		// 將 newId 設定給 book
		book.setId(newId);
		return books.add(book);
	}

	@Override
	public boolean updateBook(Integer id, Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBook(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
