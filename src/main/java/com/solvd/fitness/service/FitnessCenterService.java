package com.solvd.fitness.service;

import com.solvd.fitness.dao.FitnessCenterDao;
import com.solvd.fitness.model.FitnessCenter;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FitnessCenterService {

    private final FitnessCenterDao fitnessCenterDao = new FitnessCenterDao();

    public List<FitnessCenter> getAll() {
        try {
            return fitnessCenterDao.getAllCenters();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get Fitness Centers", e);
        }
    }

    public Optional<FitnessCenter> findByPerson(int personId) {
        try {
            return fitnessCenterDao.findByPerson(personId);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find a Fitness Center", e);
        }
    }
}
