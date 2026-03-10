package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 可以省去撰寫 @ResponseBody
public class ApiController {
	
	/**
	 * 1. API 首頁
	 * 路徑1: /home
	 * 路徑2: /welcome
	 * 網址1: http://localhost:8080/home
	 * 網址2: http://localhost:8080/welcome
	 * */
	@GetMapping(value = {"/home", "/welcome"}, produces = "text/plain;charset=utf-8")
	public String home() {
		return "我是 API 首頁";
	}
	
}
