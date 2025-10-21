package com.solvd.fitness.dao;

import com.solvd.fitness.model.FitnessCenter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FitnessCenterDao extends BaseDao<FitnessCenter> {

    private static final String SQL_FIND_ALL = "select id, name from Fitness_center";

    private static final String SQL_FIND_BY_PERSON = """
            select fc.id, fc.name from Fitness_center fc
            join Person p on p.fitness_center_id=fc.id
            where p.id=%d
            """;

    private FitnessCenter createFitnessCenter(ResultSet rs) throws SQLException {
        FitnessCenter fc = new FitnessCenter();
        fc.setId(rs.getInt("id"));
        fc.setName(rs.getString("name"));
        return fc;
    }

    public List<FitnessCenter> getAllCenters() throws SQLException {
        return getMany(SQL_FIND_ALL, this::createFitnessCenter);
    }

    public Optional<FitnessCenter> findByPerson(int personId) throws SQLException {
        return getOne(String.format(SQL_FIND_BY_PERSON, personId), this::createFitnessCenter);
    }
}
