package com.example.demo.test_controller;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.rental.model.dto.auth.RegisterRequest;
import com.example.demo.rental.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class AuthControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void register() throws Exception {
		
		String json = """
				{
				   "username": "user4",
				   "password": "444444",
				   "fullName": "陳曉明",
				   "phone": "0944444444"
				}
				""";
		
		mockMvc.perform(post("/api/auth/register")
				.with(csrf()) // 防止跨站請求偽造
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isOk());
		
		// 驗證 AuthService.register() 真的有被呼叫到一次
		//verify(authService, times(1)).register((RegisterRequest) any(RegisterRequest.class));
	}
}