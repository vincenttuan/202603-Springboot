package com.example.demo.proxy;

// 計算器實現
public class CalcImpl implements Calc {

	@Override
	public Integer add(Integer x, Integer y) {
		// 業務邏輯
		return x + y;
	}

	@Override
	public Integer div(Integer x, Integer y) {
		// 業務邏輯
		return x / y;
	}

}
