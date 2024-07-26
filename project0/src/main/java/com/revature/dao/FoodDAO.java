package com.revature.dao;

import com.revature.model.Food;

import java.util.List;

public interface FoodDAO {
    public Food addFood(Food f);
    public boolean removeFood(int id);
    public Food getFood(int id);
    public Food updateFood(Food change);
    public List<Food> getAllFoods();
}
