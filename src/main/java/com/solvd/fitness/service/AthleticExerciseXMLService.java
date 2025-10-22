package com.solvd.fitness.service;

import com.solvd.fitness.model.AthleticExercise;
import com.solvd.fitness.util.dom.AthleticExerciseDomParser;
import java.util.List;

public class AthleticExerciseXMLService {

    private static final String XML_PATH = "src/main/resources/athleticExercise.xml";

    public List<AthleticExercise> getAthleticExercises() {
        return new AthleticExerciseDomParser().parse(XML_PATH);
    }
}
