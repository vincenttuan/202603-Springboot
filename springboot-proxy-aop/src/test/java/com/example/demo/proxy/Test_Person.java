package com.example.demo.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test_Person {
	
	@Test
	public void test() {
		// 一般用法
		Person man = new Man();
		Person woman = new Woman();
		man.work();
		woman.work();
	}
}
