package Controller;

import Entity.Category;
import Entity.Objekt;
import Entity.SimpleCategory;
import Entity.CategoryStatus;
import jobs.TxtReader;

import java.util.ArrayList;
import java.util.List;

public class ManageElement {

    private static List<Category> arten;
    private static List<Category> stimmungen;
    private static List<Category> objekte;

    public ManageElement() {
        reloadElements();
    }

    public static void reloadElements() {
        arten = TxtReader.readEntity(CategoryStatus.ART);
        stimmungen = TxtReader.readEntity(CategoryStatus.STIMMUNG);
        objekte = TxtReader.readEntity(CategoryStatus.OBJEKT);
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

    public static Category getCategoryToDescription(String description) {
        Category category = searchCategoryToDescription(description, arten);
        if(category == null) {
            category = searchCategoryToDescription(description, stimmungen);
        }
        if(category == null) {
            category = searchCategoryToDescription(description, objekte);
        }
        return category;
        //TODO try catch category == null
    }

    private static Category searchCategoryToDescription(String description, List<Category> elements) {
        for(Category element : elements) {
            if(element.getDescription().equals(description)) {
                return element;
            }
        }
        return null;
    }

    public static Category[] toArray(List<Category> elementsList) {
        Category[] elements = new Category[elementsList.size()];
        for (int countElements = 0; countElements < elementsList.size(); countElements++) {
            elements[countElements] = elementsList.get(countElements);
        }
        return elements;
    }

    public static List<String> toStringList(List<Category> elementsList) {
        List<String> elementsListString = new ArrayList<>();
        for (Category element : elementsList) {
            elementsListString.add(element.getDescription());
        }

        return elementsListString;
    }
}
