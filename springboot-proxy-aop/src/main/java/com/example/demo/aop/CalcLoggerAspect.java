package com.example.demo.aop;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component // 被 Spring 來管理
@Aspect // 切面程式
@Order(1) // 調用順序
public class CalcLoggerAspect {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	// 前置通知(Advice)
	@Before(value = "execution(public Integer com.example.demo.proxy.CalcImpl.add(Integer, Integer)")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName(); // 取得方法名稱
		Object[] args = joinPoint.getArgs();
		String dateTime = sdf.format(new Date());
		// Log 紀錄
		System.out.printf("Log 前置通知[%s]: %s %s %n", dateTime, methodName, Arrays.toString(args));
	}
}
