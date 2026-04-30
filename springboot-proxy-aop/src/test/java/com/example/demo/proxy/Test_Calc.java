package com.example.demo.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test_Calc {
	
	@Autowired
	private Calc calc;
	
	@Test
	public void test() {
		// 加法
		System.out.println(calc.add(20, 10)); // 顯示: 30
		System.out.println(calc.add(null, 10)); // 顯示: 參數不正確
		
		// 除法
		System.out.println(calc.div(20, 10)); // 顯示: 2
		System.out.println(calc.div(null, 10)); // 顯示: 參數不正確
		
	}
	
}
