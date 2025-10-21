package com.solvd.fitness.dao;

import com.solvd.fitness.model.ActivityLevel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ActivityLevelDao extends BaseDao<ActivityLevel> {

    private static final String SQL_ALL_ACTIVITY_LEVELS = "select id, activity_level from Activity_level";

    private ActivityLevel createActivityLevel(ResultSet rs) throws SQLException {
        return new ActivityLevel(rs.getInt("id"), rs.getString("activity_level"));
    }

    public List<ActivityLevel> getAllActivityLevels() throws SQLException {
        return getMany(SQL_ALL_ACTIVITY_LEVELS, this::createActivityLevel);
    }
}
