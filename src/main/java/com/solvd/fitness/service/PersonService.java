package com.solvd.fitness.service;

import com.solvd.fitness.dao.PersonDao;
import com.solvd.fitness.model.Person;

import java.sql.SQLException;
import java.util.List;

public class PersonService {

    private final PersonDao personDao = new PersonDao();

    public List<Person> getAllPersons() {
        try {
            return personDao.getAllPersons();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get persons", e);
        }
    }
}
