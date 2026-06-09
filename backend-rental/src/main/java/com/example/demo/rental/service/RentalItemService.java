package com.example.demo.rental.service;

import org.springframework.stereotype.Service;

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

}
