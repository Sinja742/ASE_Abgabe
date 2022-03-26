package Controller;

import Entity.Entity;
import Entity.Tags;
import Entity.EntityStatus;
import jobs.TxtReader;

import java.util.ArrayList;
import java.util.List;

public class ElementeController {

    private static List<Entity> arten;
    private static List<Entity> stimmungen;
    private static List<Entity> objekte;
    private static List<String> artenToString = new ArrayList<>();
    private static List<String> stimmungenToString = new ArrayList<>();
    private static List<String> objekteToString = new ArrayList<>();
    private static List<String> tagsToString = new ArrayList<>();

    ElementeController() {
        this.arten = TxtReader.readEntity(EntityStatus.ART);
        this.stimmungen = TxtReader.readEntity(EntityStatus.STIMMUNG);
        this.objekte = TxtReader.readEntity(EntityStatus.OBJEKT);

        this.getStringLists();
        this.readAllTags();
    }

    private void getStringLists() {
        this.artenToString = entityListToStringList(this.arten);
        this.stimmungenToString = entityListToStringList(this.stimmungen);
        this.objekteToString = entityListToStringList(this.objekte);
    }

    private List<String> entityListToStringList(List<Entity> allElements) {
        List<String> entityListString = new ArrayList<>();
        for(Entity element : allElements) {
            entityListString.add(element.toString());
        }

        return entityListString;
    }

    private static void readAllTags() {
        for(Tags tag : Tags.values()) {
            tagsToString.add(tag.toString());
        }
    }

    public List<Entity> getAllArten() {
        return this.arten;
    }

    public List<Entity> getAllStimmungen() {
        return this.stimmungen;
    }

    public List<Entity> getAllObjekte() {
        return this.objekte;
    }

    public List<String> getAllStringArten() {
        return this.artenToString;
    }

    public List<String> getAllStringStimmungen() {
        return this.stimmungenToString;
    }

    public List<String> getAllStringObjekte() {
        return this.objekteToString;
    }

    public List<String> getAllStringTags() {
        return this.tagsToString;
    }
}
