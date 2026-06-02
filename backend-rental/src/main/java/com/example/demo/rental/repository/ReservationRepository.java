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
	
	boolean existsByItemIdAndStatusInStartTimeLessThanAndEndTimeGreaterThan(
			Long itemId, 
			Collection<ReservationStatus> statuses, 
			LocalDateTime newEndTime,
			LocalDateTime startEndTime);
}
