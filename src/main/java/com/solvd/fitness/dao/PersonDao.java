package com.solvd.fitness.dao;

import com.solvd.fitness.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonDao extends BaseDao<Person> {

    private static final String SQL_ALL = """
            select id, name, height, weight, gender from Person
            """;

    private Person createPerson(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setHeight(rs.getInt("height"));
        person.setWeight(rs.getInt("weight"));
        person.setGender(rs.getString("gender"));
        return person;
    }

    public List<Person> getAllPersons() throws SQLException {
        return getMany(SQL_ALL, this::createPerson);
    }
}
