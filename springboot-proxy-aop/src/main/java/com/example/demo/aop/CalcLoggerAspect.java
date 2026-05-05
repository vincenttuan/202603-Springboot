package com.example.demo.aop;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component // 被 Spring 來管理
@Aspect // 切面程式
@Order(1) // 調用順序
public class CalcLoggerAspect {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	// 建立一個切入點邏輯方法
	@Pointcut(value = "execution(public Integer com.example.demo.proxy.CalcImpl.add(Integer, Integer))")
	public void ptAdd() {}
	
	@Pointcut(value = "execution(public Integer com.example.demo.proxy.CalcImpl.div(Integer, Integer))")
	public void ptDiv() {}
	
	// 前置通知(Advice)
	//@Before(value = "execution(public Integer com.example.demo.proxy.CalcImpl.add(Integer, Integer))")
	//@Before(value = "execution(public Integer com.example.demo.proxy.CalcImpl.div(Integer, Integer))")
	//@Before(value = "execution(public Integer com.example.demo.proxy.CalcImpl.*(Integer, Integer))")
	//@Before(value = "execution(public * com.example.demo.proxy.CalcImpl.*(..))") // .. 表示任意參數的組合
	//@Before(value = "execution(public * com.example.demo.proxy.*.*(..))") // .. 表示任意參數的組合
	//@Before(value = "execution(public * *(..))") // 全域攔截
	//@Before(value = "ptAdd()")
	@Before(value = "ptAdd() || ptDiv()") // 支援邏輯運算子: &&, ||, !
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName(); // 取得方法名稱
		Object[] args = joinPoint.getArgs();
		String dateTime = sdf.format(new Date());
		// Log 紀錄
		System.out.printf("Log 前置通知[%s]: %s %s %n", dateTime, methodName, Arrays.toString(args));
	}
}
