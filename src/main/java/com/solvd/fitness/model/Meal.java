package com.solvd.fitness.model;

public class Meal {

    private Integer id;
    private String meal_type;

    public Meal(Integer id, String meal_type) {
        this.id = id;
        this.meal_type = meal_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeal_type() {
        return meal_type;
    }

    public void setMeal_type(String meal_type) {
        this.meal_type = meal_type;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", meal_type='" + meal_type + '\'' +
                '}';
    }
}
