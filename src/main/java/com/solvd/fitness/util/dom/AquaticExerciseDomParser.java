package com.solvd.fitness.util.dom;

import com.solvd.fitness.model.AquaticExercise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AquaticExerciseDomParser {

    private static final Logger LOGGER = LogManager.getLogger(AquaticExerciseDomParser.class);

    public List<AquaticExercise> parse(String filePath) {
        List<AquaticExercise> aquaticExercise = new ArrayList<>();

        try {
            Document doc = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(new File(filePath));

            NodeList nodeList = doc.getElementsByTagName("AquaticExercise");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element aquaticExerciseElement = (Element) nodeList.item(i);

                int id = Integer.parseInt(aquaticExerciseElement.getAttribute("id"));
                String type = aquaticExerciseElement.getElementsByTagName("type").item(0).getTextContent();
                int exercise_id = Integer.parseInt(aquaticExerciseElement.getElementsByTagName("exercise_id").item(0).getTextContent());

                aquaticExercise.add(new AquaticExercise(id, type, exercise_id));
            }
        } catch (Exception e) {
            LOGGER.error("Failed to parse", e);
        }
        return aquaticExercise;
    }


}
