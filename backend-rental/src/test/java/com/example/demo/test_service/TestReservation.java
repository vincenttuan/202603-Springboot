package com.example.demo.test_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.rental.service.ReservationService;

@SpringBootTest
public class TestReservation {
	
	@Autowired
	private ReservationService reservationService;
	
	@Test
	public void create() {
		
	}
	
}
