package com.example.demo.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test_DynPerson {
	
	@Test
	public void test() {
		// 動態代理測試
		DynProxy dynProxy = new DynProxy(new Man());
		Person man = (Person)dynProxy.getProxy(); // 取得代理物件
		man.work();
		
	}
	
}
