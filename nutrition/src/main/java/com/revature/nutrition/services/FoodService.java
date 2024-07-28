package com.revature.service;

import com.revature.model.Food;

import java.util.List;

public interface FoodService {
    public Food addFood(Food f);
    public boolean removeFood(int id);
    public Food getFood(int id);
    public Food updateFood(Food f);
    public List<Food> getAllFood();
}
