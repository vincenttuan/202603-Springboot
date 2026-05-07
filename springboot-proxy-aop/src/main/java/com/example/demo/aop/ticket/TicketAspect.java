package com.example.demo.aop.ticket;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 請使用 Spring AOP 攔截火車訂票方法
 * 
 * 當使用者訂票時 AOP 要檢查
 * 1.出發站不可空白
 * 2.到達站不可空白
 * 3.出發站與到達站不可相同
 * 4.張數必須介於1~6張
 * 5.上述都檢查通過才可以訂票
 * */

@Component
@Aspect
public class TicketAspect {
	
	
	
}
