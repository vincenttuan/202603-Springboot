package com.example.demo.test_service;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.rental.model.dto.reservation.ReservationCreateRequest;
import com.example.demo.rental.service.ReservationService;

@SpringBootTest
public class TestReservation {
	
	@Autowired
	private ReservationService reservationService;
	
	@Test
	public void create() {
		String username = "user";
		
		LocalDateTime startTime = LocalDateTime.now()
				.plusDays(1);
		
		LocalDateTime endTime = LocalDateTime.now()
				.plusDays(2);
		
		ReservationCreateRequest request = new ReservationCreateRequest();
		request.setItemId(1L);
		request.setStartTime(startTime);
		request.setEndTime(endTime);
		request.setNote("測試測試");
		
		try {
			var response = reservationService.create(username, request);
			System.out.println("預約成功");
		} catch (Exception e) {
			System.err.println(e);
		}
		
		
		
				
	}
	
}
