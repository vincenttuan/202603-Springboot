package com.example.demo.repository.drink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.drink.DrinkItem;
import com.example.demo.model.drink.Topping;


@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer> {

}
