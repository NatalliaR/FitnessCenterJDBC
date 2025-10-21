package com.solvd.fitness.dao;

import com.solvd.fitness.model.FitnessGoal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FitnessGoalDao extends BaseDao<FitnessGoal> {

    private static final String SQL_ALL_FITNESS_GOALS = "select id, type from Fitness_Goal";

    private FitnessGoal createFitnessGoal(ResultSet rs) throws SQLException {
        return new FitnessGoal(rs.getInt("id"), rs.getString("type"));
    }

    public List<FitnessGoal> getAllFitnessGoals() throws SQLException {
        return getMany(SQL_ALL_FITNESS_GOALS, this::createFitnessGoal);
    }
}