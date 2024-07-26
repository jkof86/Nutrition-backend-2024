package com.revature.app;

import com.revature.controller.*;
import com.revature.dao.*;
import com.revature.service.*;

import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {

        //Display title
        System.out.println("-----------------------");
        System.out.println("Nutrition App");
        System.out.println("Version 0.1.0");
        System.out.println("Created by Jason Kofi");
        System.out.println("July 3, 2024");
        System.out.println("-----------------------");


        //deprecated
        // Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());

        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(it -> {
                    it.anyHost();
                });
            });
        });

        //Establish our Routes
        establishRoutes(app);

        app.start(8080);

    }

    private static void establishRoutes(Javalin app) {

        FoodDAO fd = new FoodDAOImp();
        FoodService fs = new FoodServiceImp(fd);
        FoodController fc = new FoodController(fs);

        app.get("/hello", (context) -> context.result("Hello World!"));


        app.get("/foods", fc.getAllFood);
        app.get("/food/{id}", fc.getFoodById);
        app.post("/food", fc.createFood);
        app.delete("food/{id}", fc.removeFoodById);
        app.put("food/{id}", fc.updateFoodById);

    }

    //TESTING
//        //creates a new person and immediately prompts the user to set their calorie/macro goals
//        Person p1 = new Person("Jason");
//
//        System.out.println("-----------------------");
//
//        Food apple1 = new Food("apple");
//        Food orange1 = new Food("orange", 100, 48, .923f, 11.846f, .154f );
//
//        //should print the default "apple"" with null/default values for the remaining fields
//        System.out.println(apple1.toString());
//
//        System.out.println("-------------------");
//
//        //should print the orange name, quantity, calories, macros and null/default values for the remaining fields
//        System.out.println(orange1.toString());

}
