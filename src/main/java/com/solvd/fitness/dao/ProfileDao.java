package com.solvd.fitness.dao;

import com.solvd.fitness.model.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProfileDao extends BaseDao<Profile> {

    private static final String SQL_ALL_PROFILES = "select id, profile_type from Meal";

    private Profile createProfile(ResultSet rs) throws SQLException {
        return new Profile(rs.getInt("id"), rs.getString("profile_type"));
    }

    public List<Profile> getAllProfiles() throws SQLException {
        return getMany(SQL_ALL_PROFILES, this::createProfile);
    }

}
