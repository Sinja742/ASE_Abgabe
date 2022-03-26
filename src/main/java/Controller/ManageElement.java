package Controller;

import Entity.Category;
import Entity.Tag;
import Entity.CategoryStatus;
import jobs.TxtReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManageElement {

    private static List<Category> arten;
    private static List<Category> stimmungen;
    private static List<Category> objekte;
    private static List<Tag> tags = new ArrayList<>();
    private static List<String> artenToString = new ArrayList<>();
    private static List<String> stimmungenToString = new ArrayList<>();
    private static List<String> objekteToString = new ArrayList<>();
    private static List<String> tagsToString = new ArrayList<>();

    ManageElement() {
        this.arten = TxtReader.readEntity(CategoryStatus.ART);
        this.stimmungen = TxtReader.readEntity(CategoryStatus.STIMMUNG);
        this.objekte = TxtReader.readEntity(CategoryStatus.OBJEKT);
        this.tags.addAll(Arrays.asList(Tag.values()));

        this.getStringLists();
        this.getStringTags();
    }

    private void getStringLists() {
        this.artenToString = entityListToStringList(this.arten);
        this.stimmungenToString = entityListToStringList(this.stimmungen);
        this.objekteToString = entityListToStringList(this.objekte);
    }

    private List<String> entityListToStringList(List<Category> allElements) {
        List<String> entityListString = new ArrayList<>();
        for(Category element : allElements) {
            entityListString.add(element.toString());
        }

        return entityListString;
    }

    private static void getStringTags() {
        for(Tag tag : tags) {
            tagsToString.add(tag.getDescription());
        }
    }

    public static List<Category> getAllArten() {
        return arten;
    }

    public static List<Category> getAllStimmungen() {
        return stimmungen;
    }

    public static List<Category> getAllObjekte() {
        return objekte;
    }

    public static List<Tag> getAllTags() {
        return tags;
    }

    public static List<String> getAllStringArten() {
        return artenToString;
    }

    public static List<String> getAllStringStimmungen() {
        return stimmungenToString;
    }

    public static List<String> getAllStringObjekte() {
        return objekteToString;
    }

    public static List<String> getAllStringTags() {
        return tagsToString;
    }

    public static Category[] toArray(List<Category> elementsList) {
        Category[] elements = new Category[elementsList.size()];
        for(int countElements = 0; countElements < elementsList.size(); countElements++) {
            elements[countElements] = elementsList.get(countElements);
        }
        return elements;
    }
}
