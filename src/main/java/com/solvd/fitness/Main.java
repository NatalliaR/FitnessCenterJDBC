package com.solvd.fitness;

import com.solvd.fitness.model.ActivityLevel;
import com.solvd.fitness.model.FitnessCenter;
import com.solvd.fitness.model.FitnessGoal;
import com.solvd.fitness.model.FitnessPlan;
import com.solvd.fitness.model.Person;
import com.solvd.fitness.service.ActivityLevelService;
import com.solvd.fitness.service.FitnessCenterService;
import com.solvd.fitness.service.FitnessGoalService;
import com.solvd.fitness.service.FitnessPlanService;
import com.solvd.fitness.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        ActivityLevelService activityLevelService = new ActivityLevelService();
        PersonService personService = new PersonService();
        FitnessCenterService fitnessCenterService = new FitnessCenterService();
        FitnessGoalService fitnessGoalService = new FitnessGoalService();
        FitnessPlanService fitnessPlanService = new FitnessPlanService();

        for (ActivityLevel level : activityLevelService.getAllActivityLevels()) {
            LOGGER.info(level);
        }

        for (Person person : personService.getAllPersons()) {
            LOGGER.info(person);
        }

        for (FitnessGoal fitnessGoal : fitnessGoalService.getAllFitnessGoals()) {
            LOGGER.info(fitnessGoal);
        }

        for (FitnessPlan fitnessPlan : fitnessPlanService.getAllFitnessPlans()) {
            LOGGER.info(fitnessPlan);
        }

        Optional<FitnessCenter> fitnessCenter = fitnessCenterService.findByPerson(1);
        LOGGER.info(fitnessCenter);
    }
}
