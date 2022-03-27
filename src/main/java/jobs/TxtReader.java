package jobs;

import Entity.Category;
import Entity.Objekt;
import Entity.CategoryStatus;
import Entity.Tag;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class TxtReader {
    public static String[] readTxt() {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("resources/Elemente.txt"));
            String text = bfr.readLine();
            bfr.close();
            return text.split("&&");
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static List<Category> readEntity(CategoryStatus entityStatus) {
        if (CategoryStatus.OBJEKT.isEqualCategory(entityStatus.getStatus())) {
            return getObjekt();
        } else {
            return getEntity(entityStatus);
        }
    }

    private static List<Category> getEntity(CategoryStatus entityStatus) {
        List<Category> entityList = new ArrayList<>();
        String[] text = readTxt();
        String entityText;
        if (text != null) {
            if (entityStatus.equals(CategoryStatus.ART)) {
                entityText = text[0];
            } else {
                entityText = text[1];
            }
            text = entityText.split(",");

            for (String s : text) {
                entityList.add(new Category(s));
            }
        }
        return entityList;
    }

    public static List<Category> getObjekt() {
        List<Category> objektList = new ArrayList<>();
        String[] text = readTxt();

        if (text != null) {
            text = text[2].split(";");
            for (String s : text) {
                String[] objekt = s.split(",");
                String bezeichnung = objekt[0];
                objektList.add(new Objekt(bezeichnung, getTags(objekt)));
            }
        }
        return objektList;
    }

    public static List<Tag> getTags(String[] objekt) {
        List<Tag> tagList = new ArrayList<>();
        for(int objektAttribute = 1; objektAttribute < objekt.length; objektAttribute++) {
            tagList.add(Tag.getTag(Integer.parseInt(objekt[objektAttribute])));
        }
        return tagList;
    }
}
