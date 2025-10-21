package com.solvd.fitness.service;

import com.solvd.fitness.dao.FitnessGoalDao;
import com.solvd.fitness.model.FitnessGoal;

import java.sql.SQLException;
import java.util.List;

public class FitnessGoalService {

    private final FitnessGoalDao dao = new FitnessGoalDao();

    public List<FitnessGoal> getAllFitnessGoals() {
        try {
            return dao.getAllFitnessGoals();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to list all fitness goals", e);
        }
    }

}
