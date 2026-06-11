package com.example.demo.rental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 負責整個系統的安全機制 - Spring Security 設定
 * 
 * 包含:
 * 1. 那些 API 可以公開存取
 * 2. 那些 API 需要登入
 * 3. 那些 API 需要特定角色
 * 4. 關閉 CSRF (因為 JWT)
 * 5. 啟用 CORS (設定前端合法位置)
 * 6. 設定 JWT Filter
 * 7. 設定 Stateless Session (因為 JWT)
 * 8. 設定密碼加密方式
 * 9. 設定 AuthenticationProvider
 * 10 設定 AuthenticationManager
 * 
 * */
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	// 設定密碼加密方式
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
