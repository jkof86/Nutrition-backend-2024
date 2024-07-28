package com.revature.service;

import com.revature.dao.*;
import com.revature.model.Food;

import java.util.List;

public class FoodServiceImp implements FoodService{

    private FoodDAO fd;

    public FoodServiceImp(FoodDAO fd){
        this.fd = fd;
    }

    @Override
    public Food addFood(Food f) {

        return fd.addFood(f);
    }

    @Override
    public boolean removeFood(int id) {
        return fd.removeFood(id);
    }

    @Override
    public Food getFood(int id) {
        return fd.getFood(id);
    }

    @Override
    public Food updateFood(Food f) {
        return fd.updateFood(f);
    }

    @Override
    public List<Food> getAllFood() {
        return fd.getAllFoods();
    }
}
