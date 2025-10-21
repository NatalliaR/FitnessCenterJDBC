package com.solvd.fitness.service;

import com.solvd.fitness.dao.ActivityLevelDao;
import com.solvd.fitness.model.ActivityLevel;

import java.sql.SQLException;
import java.util.List;

public class ActivityLevelService {

    private final ActivityLevelDao dao = new ActivityLevelDao();

    public List<ActivityLevel> getAllActivityLevels() {
        try {
            return dao.getAllActivityLevels();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to list all activity levels", e);
        }
    }
}
