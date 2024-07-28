package com.revature.controller;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import com.revature.model.*;
import com.revature.service.*;
import io.javalin.http.HttpStatus;

import java.util.List;

public class FoodController {

    private FoodService fs;
    private Gson gson = new Gson();

    public FoodController(FoodService fs) {
        this.fs = fs;
    }

    public Handler createFood = (context) -> {
        Food f = gson.fromJson(context.body(), Food.class);
        f = fs.addFood(f);

        if (f != null) {
            context.status(HttpStatus.OK);
            context.result(gson.toJson(f));
        } else {
            context.status(HttpStatus.NOT_FOUND);
            context.result(gson.toJson(f));
        }
    };

    public Handler getAllFood = (context) -> {

        List<Food> food = fs.getAllFood();
        String foodJSON = gson.toJson(food);

        //if food list is empty, we return a 404 status code
        if (!food.isEmpty()) {
            context.status(HttpStatus.OK);
            context.result(foodJSON);
        } else {
            context.status(HttpStatus.NOT_FOUND);
            context.result(foodJSON);
        }
    };

    public Handler getFoodById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Food f = fs.getFood(id);

        if (f != null) {
            context.status(HttpStatus.OK);
            context.result(gson.toJson(f));
        } else {
            context.status(HttpStatus.NOT_FOUND);
            context.result(gson.toJson(f));
        }
    };

    public Handler removeFoodById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        boolean f = fs.removeFood(id);

        if (f) {
            context.status(HttpStatus.OK);
            context.result(gson.toJson(f));
        } else {
            context.status(HttpStatus.NOT_FOUND);
            context.result(gson.toJson(f));
        }
    };

    public Handler updateFoodById = (context) -> {

        //we need to duplicate the Food obj to update properly

        int id = Integer.parseInt(context.pathParam("id"));
        Food fChange = gson.fromJson(context.body(), Food.class);

        //first we grab the food item
        Food f = fs.getFood(id);

        //if the record exists,we update the proper fields
        if (f != null) {
            f.setId(id);
            f.setAvailable(fChange.isAvailable());
            f.setQuantity(fChange.getQuantity());
            f.setCalories(fChange.getCalories());
            f.setProtein(fChange.getProtein());
            f.setCarbs(fChange.getCarbs());
            f.setFat(fChange.getFat());

            //and we add the updated Food to the DB (with a new id due to serial pkey)
            f = fs.addFood(f);

            //then we remove the original food based on the given id path parameter
            fs.removeFood(id);

            //finally we return the updated food to the context
            context.status(HttpStatus.OK);
            context.result(gson.toJson(f));
        }
        //otherwise we pass a fail message to the context
        else {
            //for logging
            System.out.println("Update Failed");
            context.status(HttpStatus.NOT_FOUND);
            context.result("Update Failed");
        }

    };

//    Test
//    public void anotherHandle(Context ctx) {
//        ctx.result("Another example");
//    }

}