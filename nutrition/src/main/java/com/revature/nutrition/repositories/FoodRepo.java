package com.revature.nutrition.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.nutrition.models.Food;

@Repository
public interface FoodRepo extends JpaRepository<Food,Integer> {

}
