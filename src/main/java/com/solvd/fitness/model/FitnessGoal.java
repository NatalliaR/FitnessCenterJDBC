package com.solvd.fitness.model;

public class FitnessGoal {

    private final Integer id;
    private final String type;

    public FitnessGoal(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "FitnessGoal{" +
                "id=" + id +
                ", name='" + type + '\'' +
                '}';
    }

}
