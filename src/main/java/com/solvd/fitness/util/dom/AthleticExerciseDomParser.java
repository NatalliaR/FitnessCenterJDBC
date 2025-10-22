package com.solvd.fitness.util.dom;

import com.solvd.fitness.model.AthleticExercise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class AthleticExerciseDomParser {

    private static final Logger LOGGER = LogManager.getLogger(AthleticExerciseDomParser.class);

    public List<AthleticExercise> parse(String filePath) {
        List<AthleticExercise> athleticExercise = new ArrayList<>();

        try {
            Document doc = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(new File(filePath));

            NodeList nodeList = doc.getElementsByTagName("AthleticExercise");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element athleticExerciseElement = (Element) nodeList.item(i);

                int id = Integer.parseInt(athleticExerciseElement.getAttribute("id"));
                String type = athleticExerciseElement.getElementsByTagName("type").item(0).getTextContent();
                int exercise_id = Integer.parseInt(athleticExerciseElement.getElementsByTagName("exercise_id").item(0).getTextContent());

                athleticExercise.add(new AthleticExercise(id, type, exercise_id));
            }
        } catch (Exception e) {
            LOGGER.error("Failed to parse", e);
        }
        return athleticExercise;
    }

}
