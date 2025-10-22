package com.solvd.fitness.dao;

import com.solvd.fitness.model.Exercise;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExerciseDao extends BaseDao<Exercise> {

    private static final String SQL_ALL_EXERCISES = "select id, exercise_type from Exercise";

    private Exercise createExercise(ResultSet rs) throws SQLException {
        return new Exercise(rs.getInt("id"), rs.getString("exercise_type"));
    }

    public List<Exercise> getAllExercises() throws SQLException {
        return getMany(SQL_ALL_EXERCISES, this::createExercise);
    }

}
