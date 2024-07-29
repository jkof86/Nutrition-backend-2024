package com.revature.models;

import jakarta.persistence.*;

@Entity
@Table(name = "foods")
public class Food {

    @Id //makes this a Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id", updatable = false)
    private int id;

    private String name;

    private boolean available;

    //quantity in grams
    private int quantity;

    //calories in kcal
    private int calories;

    //macronutrients in grams
    private float protein;
    private float carbs;
    private float fat;

    //micronutrients
    private float fiber;
    private float sugar;
    private float cholesterol;
    private float sodium;
    private float potassium;
    private float vitaminA;
    private float vitaminC;
    private float calcium;
    private float iron;

    //constructors
    public Food(){}

    public Food(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Food(int id,String name, int quantity, int calories, float protein, float carbs, float fat) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Getters/Setters and toString
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getCarbs() {
        return carbs;
    }

    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getFiber() {
        return fiber;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }

    public float getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public float getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public float getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public float getPotassium() {
        return potassium;
    }

    public void setPotassium(int potassium) {
        this.potassium = potassium;
    }

    public float getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(int vitaminA) {
        this.vitaminA = vitaminA;
    }

    public float getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(int vitaminC) {
        this.vitaminC = vitaminC;
    }

    public float getCalcium() {
        return calcium;
    }

    public void setCalcium(int calcium) {
        this.calcium = calcium;
    }

    public float getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }

    @Override
    public String toString() {
        return "Food { " +
                "name='" + this.name+ '\'' +
                ", quantity=" + this.quantity +
                ", calories=" + this.calories +
                ", protein=" + this.protein +
                ", carbs=" + this.carbs +
                ", fat=" + this.fat +
                ", fiber=" + this.fiber +
                ", sugar=" + this.sugar +
                ", cholesterol=" + this.cholesterol +
                ", sodium=" + this.sodium +
                ", potassium=" + this.potassium +
                ", vitaminA=" + this.vitaminA +
                ", vitaminC=" + this.vitaminC +
                ", calcium=" + this.calcium +
                ", iron=" + this.iron +
                " }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
