package com.example.demo.test_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.rental.exception.ResourceNotFoundException;
import com.example.demo.rental.model.dto.item.RentalItemResponse;
import com.example.demo.rental.service.RentalItemService;

@SpringBootTest
public class FindRentalItem {
	
	@Autowired
	private RentalItemService rentalItemService;
	
	//@Test
	public void find() {
		String keyword = null; // "電腦", "4k"
		String type = null; // "教室", "設備" , "場地"
		var list = rentalItemService.findAll(keyword, type);
		
		System.out.println("筆數: " + list.size());
		list.forEach(System.out::println);
		
	}
	
	@Test
	public void findById() {
		Long id = 1L;
		try {
			var rentalItemResponse = rentalItemService.findById(id);
			System.out.println(rentalItemResponse);
		} catch (ResourceNotFoundException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
}
