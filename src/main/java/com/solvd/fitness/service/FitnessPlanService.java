package com.solvd.fitness.service;

import com.solvd.fitness.dao.FitnessPlanDao;
import com.solvd.fitness.model.FitnessPlan;

import java.sql.SQLException;
import java.util.List;

public class FitnessPlanService {

    private final FitnessPlanDao dao = new FitnessPlanDao();

    public List<FitnessPlan> getAllFitnessPlans() {
        try {
            return dao.getAllFitnessPlans();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to list all fitness plans", e);
        }
    }

}
