package com.example.demo.repository.drink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.drink.DrinkDetail;


@Repository
public interface DrinkDetailRepository extends JpaRepository<DrinkDetail, Integer> {

}
