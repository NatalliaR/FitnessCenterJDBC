package com.solvd.fitness.model;

public class FitnessPlan {

    private Integer id;
    private String name;

    public FitnessPlan(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FitnessPlan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
