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
        if (isObjekt(entityStatus)) {
            return getObjekt(entityStatus);
        } else {
            return getEntity(entityStatus);
        }
        //return (isObjekt(entityStatus) ? getObjekt() : getEntity(entityStatus));
    }

    private static boolean isObjekt(CategoryStatus entityStatus) {
        return entityStatus.equals(CategoryStatus.OBJEKT);
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

    public static List<Category> getObjekt(CategoryStatus entityStatus) {
        List<Category> objektList = new ArrayList<>();
        String[] text = readTxt();

        if (text != null) {
            text = text[2].split(";");
            for (String s : text) {
                List<Tag> tagList = new ArrayList<>();
                String[] objekt = s.split(",");
                String bezeichnung = objekt[0];
                for(int objektAttribute = 1; objektAttribute < objekt.length; objektAttribute++) {
                    tagList.add(Tag.getTag(Integer.parseInt(objekt[objektAttribute])));
                }
                objektList.add(new Objekt(bezeichnung, tagList));
            }
        }
        return objektList;
    }
}
