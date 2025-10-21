package com.solvd.fitness.model;

public class ActivityLevel {

    private final Integer id;
    private final String activityLevel;

    public ActivityLevel(Integer id, String activityLevel) {
        this.id = id;
        this.activityLevel = activityLevel;
    }

    public Integer getId() {
        return id;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    @Override
    public String toString() {
        return "ActivityLevel{" +
                "id=" + id +
                ", activityLevel='" + activityLevel + '\'' +
                '}';
    }
}
