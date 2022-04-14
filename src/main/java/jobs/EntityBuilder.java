package jobs;

import Entity.*;

import java.util.ArrayList;
import java.util.List;

// TODO: Refactoring !!!!!!!!!!!!!
public class EntityBuilder {

    private final TxtHandling handlerTxt;

    public EntityBuilder() {
        this.handlerTxt = new TxtHandling();
    }

//    Erzeugungsmuster
    public List<Category> readEntity(CategoryStatus categoryStatus) {
        if (CategoryStatus.OBJEKT.isEqualCategory(categoryStatus)) {
            return getObjekt();
        } else {
            return getEntity(categoryStatus);
        }
    }

    private List<Category> getEntity(CategoryStatus entityStatus) {
        List<Category> entityList = new ArrayList<>();
        String[] text = this.handlerTxt.readTxt();
        String entityText;
        if (text != null) {
            if (entityStatus.equals(CategoryStatus.ART)) {
                entityText = text[0];
            } else {
                entityText = text[1];
            }
            text = entityText.split(",");

            for (String s : text) {
                entityList.add(new SimpleCategory(s));
            }
        }
        return entityList;
    }

    private List<Category> getObjekt() {
        List<Category> objektList = new ArrayList<>();
        String[] text = this.handlerTxt.readTxt();

        if (text != null) {
            text = text[2].split(",");
            for (String s : text) {
                String[] objekt = s.split(";");
                String bezeichnung = objekt[0];
                objektList.add(new Objekt(bezeichnung, getTags(objekt)));
            }
        }
        return objektList;
    }

    private List<Tag> getTags(String[] objekt) {
        List<Tag> tagList = new ArrayList<>();
        for(int objektAttribute = 1; objektAttribute < objekt.length; objektAttribute++) {
            tagList.add(Tag.getTag(Integer.parseInt(objekt[objektAttribute])));
        }
        return tagList;
    }
}
