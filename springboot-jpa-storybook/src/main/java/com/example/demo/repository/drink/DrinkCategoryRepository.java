package com.example.demo.repository.drink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.drink.DrinkCategory;

@Repository
public interface DrinkCategoryRepository extends JpaRepository<DrinkCategory, Integer> {

}
