package com.example.demo.test_controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.rental.model.dto.reservation.ReservationCreateRequest;
import com.example.demo.rental.service.RentalItemService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ReservationControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private RentalItemService rentalItemService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	@WithMockUser(username = "user", roles = {"USER"})
	public void createReservation() throws Exception {
		ReservationCreateRequest request = new ReservationCreateRequest();
		request.setItemId(5L);
		request.setStartTime(LocalDateTime.now().plusDays(1));
		request.setStartTime(LocalDateTime.now().plusDays(3));
		request.setNote("測試用");
		
		MvcResult result = mockMvc.perform(post("/reservations")
				.with(csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		System.out.println(result);
		
	}
	
}
