package com.example.demo.aop.floor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.floor.FloorService;

@SpringBootTest
public class Test_FloorAOP {
	
	@Autowired
	private FloorService floorService;
	
	@Test
	public void test() {
		String username = "john";
		int floor = 1;
		
		try {
			String result = floorService.enterFloor(username, floor);
			System.out.println(result);
		} catch (Throwable e) {
			System.err.println(e.getMessage());
		}
	}
	
}
