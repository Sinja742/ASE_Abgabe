package jobs;

import Entity.Entity;
import Entity.Objekt;
import Entity.EntityStatus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class TxtReader {
    public static String[] readYml() {
        try {
            String text = new BufferedReader(new FileReader("Elemente.txt")).readLine();
            return text.split("&&");
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static List<Entity> readEntity(EntityStatus entityStatus) {
        if (isObjekt(entityStatus)) {
            return getObjekt(entityStatus);
        } else {
            return getEntity(entityStatus);
        }
        //return (isObjekt(entityStatus) ? getObjekt() : getEntity(entityStatus));
    }

    private static boolean isObjekt(EntityStatus entityStatus) {
        return entityStatus.equals(EntityStatus.OBJEKT);
    }

    private static List<Entity> getEntity(EntityStatus entityStatus) {
        List<Entity> entityList = new ArrayList<>();
        String[] text = readYml();
        String entityText;
        if (text != null) {
            if (entityStatus.equals(EntityStatus.ART)) {
                entityText = text[0];
            } else {
                entityText = text[1];
            }
            text = entityText.split(",");

            for (String s : text) {
                entityList.add(new Entity(s));
            }
        }
        return entityList;
    }

    public static List<Entity> getObjekt(EntityStatus entityStatus) {
        List<Entity> objektList = new ArrayList<>();
        String[] text = readYml();

        if (text != null) {
            text = text[2].split(";");
            for (String s : text) {
                List<String> tagList = new ArrayList<>();
                String[] objekt = s.split(",");
                for (String value : objekt) {
                    tagList.add(value);
                }
                String bezeichnung = tagList.get(0);
                tagList.remove(0);
                objektList.add(new Objekt(bezeichnung, tagList));
            }
        }
        return objektList;
    }
}
