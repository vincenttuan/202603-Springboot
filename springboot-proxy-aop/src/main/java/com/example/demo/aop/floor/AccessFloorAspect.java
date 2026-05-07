package com.example.demo.aop.floor;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 寫一個通知
 * 若通過門禁印出:  [AOP] xxx 授權進入 n 樓
 * 若不通過門禁印出: [AOP] xxx 未授權授權進入 n 樓
 * */
@Component
@Aspect
public class AccessFloorAspect {
	
	
	
}
