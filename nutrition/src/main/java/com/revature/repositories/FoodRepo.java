package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.Food;

@Repository
public interface FoodRepo extends JpaRepository<Food,Integer> {

}
