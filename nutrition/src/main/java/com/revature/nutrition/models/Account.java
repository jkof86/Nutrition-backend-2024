package com.revature.nutrition.models;

import jakarta.persistence.*;

import java.util.Scanner;

@Entity
@Table(name = "accounts")
public class Account {

    @Id //makes this a Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a_id", updatable = false)
    private int id;

    private String fname;
    private  String lname;
    private String pw;

    private int age;
    private int height; //in cm
    private int weight; //in lbs

    //daily calorie and macronutrient goals
    private int calorieLimit;
    private int protein;
    private int carbs;
    private int fat;

    public Account(){

    }
    public Account(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;

        //immediately set Calorie and Macro goals upon person object creation
        calculateCalories();
        //print results
        System.out.println("-----------------------");
        System.out.println(toString());
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public int getCalorieLimit() {
        return calorieLimit;
    }

    public void setCalorieLimit(int calorieLimit) {
        this.calorieLimit = calorieLimit;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "Calorie / Macronutrient Goals { " +
                "name='" + fname +  " " + lname + '\'' +
                ", calorieLimit=" + calorieLimit +
                ", protein=" + protein +
                ", carbs=" + carbs +
                ", fat=" + fat +
                " }";
    }

    private void calculateCalories() {

        // prompt user to enter the total daily calorie limit
        System.out.print("Enter the total daily calorie limit: ");
        Scanner scanner = new Scanner(System.in);

        calorieLimit = scanner.nextInt();

        // prompt user to enter three macronutrient percentage values
        System.out.print("Enter the percentage of protein: ");
        int proteinPercentage = scanner.nextInt();
        System.out.print("Enter the percentage of carbohydrates: ");
        int carbPercentage = scanner.nextInt();
        System.out.print("Enter the percentage of fat: ");
        int fatPercentage = scanner.nextInt();

        if(proteinPercentage + carbPercentage + fatPercentage == 100) {
            // calculate the macronutrient values (in grams) given the  entered calorieLimit

            //protein has 4 calories per gram
            //carbohydrates has 4 calories per gram
            //fat has 9 calories per gram
            protein = (int) (calorieLimit * proteinPercentage / 100.0 / 4.0);
            carbs = (int) (calorieLimit * carbPercentage / 100.0 / 4.0);
            fat = (int) (calorieLimit * fatPercentage / 100.0 / 9.0);

            System.out.println("-----------------------");

            // print the macronutrient values (in grams)
            System.out.println("Protein: " + protein + " grams");
            System.out.println("Carbohydrates: " + carbs + " grams");
            System.out.println("Fat: " + fat + " grams");
        }
        else {
            System.out.println("-----------------------");
            System.out.println("Error: Macronutrient % not equal to 100");
            System.out.println("Creating person object with default goals...");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
