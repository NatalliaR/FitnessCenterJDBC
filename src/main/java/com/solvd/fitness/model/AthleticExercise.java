package com.solvd.fitness.model;

public class AthleticExercise {

    private Integer id;
    private String type;
    private Integer exercise_id;

    public AthleticExercise(Integer id, String type, Integer exercise_id) {
        this.id = id;
        this.type = type;
        this.exercise_id = exercise_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Integer exercise_id) {
        this.exercise_id = exercise_id;
    }

    @Override
    public String toString() {
        return "AthleticExercise{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", exercise_id=" + exercise_id +
                '}';
    }
}
