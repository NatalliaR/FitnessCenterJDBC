package com.solvd.fitness.dao;

import com.solvd.fitness.model.FitnessPlan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FitnessPlanDao extends BaseDao<FitnessPlan> {

    private static final String SQL_ALL_FITNESS_PLANS = "select id, name from Fitness_Plan";

    private FitnessPlan createFitnessPlan(ResultSet rs) throws SQLException {
        return new FitnessPlan(rs.getInt("id"), rs.getString("name"));
    }

    public List<FitnessPlan> getAllFitnessPlans() throws SQLException {
        return getMany(SQL_ALL_FITNESS_PLANS, this::createFitnessPlan);
    }
}

