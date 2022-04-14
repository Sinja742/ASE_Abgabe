package Controller;

import Entity.Category;
import Entity.CategoryStatus;
import jobs.EntityBuilder;
import jobs.TxtHandling;

import java.util.ArrayList;
import java.util.List;

public class ManageElement {

    private List<Category> arten;
    private List<Category> stimmungen;
    private List<Category> objekte;

    private final EntityBuilder entityBuilder;
    private final TxtHandling txtHandling;

    public ManageElement(EntityBuilder entityBuilder) {
        this.entityBuilder = entityBuilder;
        this.txtHandling = new TxtHandling();
        loadElements();
    }

    public void loadElements() {
        arten = this.entityBuilder.readEntity(CategoryStatus.ART);
        stimmungen = this.entityBuilder.readEntity(CategoryStatus.STIMMUNG);
        objekte = this.entityBuilder.readEntity(CategoryStatus.OBJEKT);
    }

    public List<Category> getAllArten() {
        return arten;
    }

    public List<Category> getAllStimmungen() {
        return stimmungen;
    }

    public List<Category> getAllObjekte() {
        return objekte;
    }

    public void addElement(Category element, CategoryStatus status) {
        if(CategoryStatus.ART.isEqualCategory(status)) {
            arten.add(element);
        }
        if(CategoryStatus.STIMMUNG.isEqualCategory(status)) {
            stimmungen.add(element);
        }
        if(CategoryStatus.OBJEKT.isEqualCategory(status)) {
            objekte.add(element);
        }

        this.txtHandling.rewrite(this.arten, this.stimmungen, this.objekte);
    }

    public void deleteElement(String elementDescription, CategoryStatus status) {
        if(CategoryStatus.ART.isEqualCategory(status)) {
            this.arten = deleteSearchElement(elementDescription, this.arten);
        }
        if(CategoryStatus.STIMMUNG.isEqualCategory(status)) {
            this.stimmungen = deleteSearchElement(elementDescription, this.stimmungen);
        }
        if(CategoryStatus.OBJEKT.isEqualCategory(status)) {
            this.objekte = deleteSearchElement(elementDescription, this.objekte);
        }

        this.txtHandling.rewrite(this.arten, this.stimmungen, this.objekte);
    }

    private List<Category> deleteSearchElement(String elementDescription, List<Category> listCategory) {
        Category element = searchCategoryToDescription(elementDescription, listCategory);
        listCategory.remove(element);
        return listCategory;

//        for(int categoryElementCounter = 0; categoryElementCounter < listCategory.size(); categoryElementCounter++) {
//            if(listCategory.get(categoryElementCounter).equalsDescription(elementDescription)) {
//                listCategory.remove(categoryElementCounter);
//                return listCategory;
//            }
//        }
//        return listCategory;
    }

    public Category getCategoryToDescription(String description) {
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

    private Category searchCategoryToDescription(String description, List<Category> elements) {
        for(Category element : elements) {
            if(element.equalsDescription(description)) {
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
