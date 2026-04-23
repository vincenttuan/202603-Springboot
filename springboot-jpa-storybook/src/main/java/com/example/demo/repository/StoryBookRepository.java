package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StoryBook;

@Repository
public interface StoryBookRepository extends JpaRepository<StoryBook, Integer> {
	
}
