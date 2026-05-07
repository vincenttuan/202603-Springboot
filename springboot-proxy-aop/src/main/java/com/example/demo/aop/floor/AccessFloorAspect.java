package com.example.demo.aop.floor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.floor.AccessController;

/**
 * 寫一個通知
 * 若通過門禁印出:  [AOP] xxx 授權進入 n 樓
 * 若不通過門禁印出: [AOP] xxx 未授權授權進入 n 樓
 * */
@Component
@Aspect
public class AccessFloorAspect {
	
	@Autowired
	private AccessController accessController;
	
	@Around(value = "execution(* com.example.demo.service.floor.FloorService.enterFloor(..))")
	public Object checkAccess(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		
		Object[] args = joinPoint.getArgs();
		String username = (String)args[0];
		int floor = (int)args[1];
		
		if(accessController.hasAccess(username, floor)) {
			System.out.printf("[AOP] %s 授權進入 %d 樓%n", username, floor);
			result = joinPoint.proceed();
		} else {
			System.err.printf("[AOP] %s 未授權進入 %d 樓%n", username, floor);
			throw new SecurityException("未授權進入該樓層");
		}
		return result;
	}
}
