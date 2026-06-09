package com.example.demo.rental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.rental.mapper.RentalItemMapper;
import com.example.demo.rental.model.dto.item.RentalItemResponse;
import com.example.demo.rental.model.entity.RentalItem;
import com.example.demo.rental.repository.RentalItemRepository;

/**
 * 租用項目服務層
 * 此類別負責處理租用項目的核心業務邏輯
 * 查詢租用項目, 新增租用項目, 修改租用項目, 刪除租用項目
 * 
 * 在系統分層架構中, 本類別位於 Controller 與 Respository 之間
 * Controller 負責接收 HTTP 請求
 * Service 負責商業邏輯
 * Respository 負責實際資料庫存取
 * 
 * 本類別不直接回傳 Entity 給前端, 而是透過 RentalItemMapper
 * 將 Entity 轉換為 Response DTO
 * 以降低資料庫模型與 API 回應格式的耦合
 * 
 * */
@Service
public class RentalItemService {
	
	// 租用項目資料存取物件
	@Autowired
	private RentalItemRepository rentalItemRepository;
	
	/* 查詢租用項目清單
	 * 參數可以輸入 keyword 與 type
	 * 回傳: List<RentalItemResponse>
	 */
	public List<RentalItemResponse> findAll(String keyword, String type) {
		boolean hasKeyword = keyword != null && !keyword.isBlank();
		boolean hastype = type != null && !type.isBlank();
		
		List<RentalItem> items;
		if(hasKeyword && hastype) {
			items = rentalItemRepository.findByNameContainingIgnoreCaseAndTypeIgnoreCase(keyword, type);
		} else if(hasKeyword) {
			items = rentalItemRepository.findByNameContainingIgnoreCase(keyword);
		} else if(hastype) {
			items = rentalItemRepository.findByTypeContainingIgnoreCase(type);
		} else {
			items = rentalItemRepository.findAll();
		}
		
		// entity 轉 DTO
		return items.stream().map(RentalItemMapper::toResponse).toList();
	}
	
	
	
	
}
