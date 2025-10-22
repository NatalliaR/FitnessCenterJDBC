package com.solvd.fitness.model;

public class Exercise {

    private Integer id;
    private String exercise_type;

    public Exercise(Integer id, String exercise_type) {
        this.id = id;
        this.exercise_type = exercise_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExercise_type() {
        return exercise_type;
    }

    public void setExercise_type(String exercise_type) {
        this.exercise_type = exercise_type;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", exercise_type='" + exercise_type + '\'' +
                '}';
    }
}
