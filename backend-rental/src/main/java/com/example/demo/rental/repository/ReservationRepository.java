package com.example.demo.rental.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.rental.model.entity.Reservation;
import com.example.demo.rental.model.enums.ReservationStatus;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findByUserIdOrderByCreatedAtDesc(Long userId);
	List<Reservation> findAllByOrderByCreatedAtDesc();
	
	// AndStatusIn 
	// 	=> 預約狀態(status)包含在傳入集合 (statuses) 當中
	// StartTimeLessThanAndEndTimeGreaterThan
	// 	=> [舊預約的開始時間] < 新傳入的時間 且 [舊預約的結束時間] > 新傳入的時間
	// 	預防訂閱區間的時間重疊
	// 	StartTimeLessThan 對應參數 newEndTime（舊開始時間 < 新結束時間）
	// 	EndTimeGreaterThan 對應參數 startEndTime（舊結束時間 > 新開始時間）
	/*
	 * 舊 startTime: 13:00
	 * 舊 endTime: 15:00
	 * 
	 * 情境一:
	 * 新 startTime: 14:00
	 * 新 endTime: 16:00
	 * 
	 * 比對:
	 * （舊開始時間 < 新結束時間） true
	 * （舊結束時間 > 新開始時間） true
	 * 
	 * 結果: 此時段已被預約
	 * 
	 * 情境二:
	 * 新 startTime: 15:30
	 * 新 endTime: 17:00
	 * 
	 * 比對:
	 * （舊開始時間 < 新結束時間） true
	 * （舊結束時間 > 新開始時間） false
	 * 
	 * 結果: 可以建立預約單
	 * 
	 * */
	
	boolean existsByItemIdAndStatusInStartTimeLessThanAndEndTimeGreaterThan(
			Long itemId, 
			Collection<ReservationStatus> statuses, 
			LocalDateTime newEndTime,
			LocalDateTime startEndTime);
}
