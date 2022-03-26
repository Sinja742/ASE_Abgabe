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

    ManageElement() {
        this.arten = TxtReader.readEntity(CategoryStatus.ART);
        this.stimmungen = TxtReader.readEntity(CategoryStatus.STIMMUNG);
        this.objekte = TxtReader.readEntity(CategoryStatus.OBJEKT);
        this.tags.addAll(Arrays.asList(Tag.values()));
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

    public static Category[] toArray(List<Category> elementsList) {
        Category[] elements = new Category[elementsList.size()];
        for(int countElements = 0; countElements < elementsList.size(); countElements++) {
            elements[countElements] = elementsList.get(countElements);
        }
        return elements;
    }

//    public static Tag[] tagsToArray(List<Tag> tagsList) {
//        Tag[] tags = new Tag[tagsList.size()];
//        for(int countTags = 0; countTags < tagsList.size(); countTags++) {
//            tags[countTags] = tagsList.get(countTags);
//        }
//        return tags;
//    }
//
//    public static List<String> toStringList(List<Category> elementsList) {
//        List<String> elementsListString = new ArrayList<>();
//        for(Category element : elementsList) {
//            elementsListString.add(element.toString());
//        }
//
//        return elementsListString;
//    }
//
//    public static List<String> tagsToStringList(List<Tag> tagsList) {
//        List<String> tagsListString = new ArrayList<>();
//        for(Tag tag : tagsList) {
//            tagsListString.add(tag.toString());
//        }
//
//        return tagsListString;
//    }
}
