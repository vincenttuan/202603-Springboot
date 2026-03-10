package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 可以省去撰寫 @ResponseBody
@RequestMapping("/api")
public class ApiController {
	
	/**
	 * 1. API 首頁
	 * 路徑1: /home
	 * 網址1: http://localhost:8080/api/home
	 * 
	 * 路徑2: /welcome
	 * 網址2: http://localhost:8080/api/welcome
	 * */
	@GetMapping(value = {"/home", "/welcome"}, produces = "text/plain;charset=utf-8")
	public String home() {
		return "我是 API 首頁";
	}
	
	/**
	 * 2. ?帶參數
	 * 路徑1: /greet?name=John&age=18
	 * 網址1: http://localhost:8080/api/greet?name=John&age=18
	 * 結果1: Hi John, 18(成年)
	 * 
	 * 路徑2: /greet?name=Mary
	 * 網址2: http://localhost:8080/api/greet?name=Mary
	 * 結果2: Hi Mary, 0(未成年)
	 * 
	 * 限制: name 為必要參數, age 為可選參數(有初始值 0)
	 * */
	//@GetMapping(value = {"/greet"})
	//@GetMapping(value = "/greet")
	@GetMapping("/greet")
	public String greet(@RequestParam(value = "name", required = true) String username,
						@RequestParam(value = "age", required = false, defaultValue = "0") Integer userage) {
		
		String result = String.format("Hi %s, %d(%s)", username, userage, userage>=18?"成年":"未成年");
		return result;
	}
	
	
}



