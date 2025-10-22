package com.solvd.fitness.service;

import com.solvd.fitness.model.AquaticExercise;
import com.solvd.fitness.util.dom.AquaticExerciseDomParser;
import java.util.List;

public class AquaticExerciseXMLService {

    private static final String XML_PATH2 = "src/main/resources/aquaticExercise.xml";

    public List<AquaticExercise> getAquaticExercises() {
        return new AquaticExerciseDomParser().parse(XML_PATH2);
    }

}
