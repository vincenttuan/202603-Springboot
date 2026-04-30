package com.example.demo.proxy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// 代理物件也要交給 Spring 來管理
@Component
@Primary // 如果有人要注入 Calc, 優先注入 CalcProxy
public class CalcProxy implements Calc {
	
	private Calc calc;
	
	// 我要注入的是 calcImpl 而不是 CalcProxy 自己
	public CalcProxy(@Qualifier("calcImpl") Calc calc) {
		this.calc = calc;
	}
	
	@Override
	public Integer add(Integer x, Integer y) {
		// 前置通知: 驗證 x, y 不可以是 null
		if(x == null || y == null) {
			System.out.println("x, y 參數不正確");
			return null;
		}
		
		// 調用業務邏輯
		Integer result = calc.add(x, y);
		
		return result;
	}

	@Override
	public Integer div(Integer x, Integer y) {
		// 前置通知: 驗證 x, y 不可以是 null
		if(x == null || y == null) {
			System.out.println("x, y 參數不正確");
			return null;
		}
		
		// 調用業務邏輯
		Integer result = calc.div(x, y);
		
		return result;
	}
	
}
