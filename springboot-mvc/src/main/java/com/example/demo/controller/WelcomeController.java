package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class WelcomeController {
	
	public String welcome(Model model) {
		// model 裡面放的就是要傳給 jsp 的資料
		model.addAttribute("name", "阿山哥");
		model.addAttribute("now", new Date());
		
		return "welcome"; // 取 welcome.jsp 檔名的部分
	}
	
}
