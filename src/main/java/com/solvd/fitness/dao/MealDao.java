package com.solvd.fitness.dao;

import com.solvd.fitness.model.Meal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MealDao extends BaseDao<Meal> {

    private static final String SQL_ALL_MEALS = "select id, meal_type from Meal";

    private Meal createMeal(ResultSet rs) throws SQLException {
        return new Meal(rs.getInt("id"), rs.getString("meal_type"));
    }

    public List<Meal> getAllMeals() throws SQLException {
        return getMany(SQL_ALL_MEALS, this::createMeal);
    }
}
