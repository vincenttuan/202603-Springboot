package com.example.demo.model.drink;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
//@Table(name = "drink_item")
public class DrinkItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// 飲料名稱: 珍珠奶茶, 拿鐵咖啡, 柳橙汁
	@Column(length = 100, nullable = false)
	private String name;
	
	// 飲料基本價格
	@Column(nullable = false)
	private Integer price;
	
	@ManyToOne
	@JoinColumn(name = "drink_category_id")
	private DrinkCategory drinkCategory;
	
	@OneToOne(mappedBy = "drinkItem")
	private DrinkDetail drinkDetail;
	
	
}
