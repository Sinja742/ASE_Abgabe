package Controller;

import Entity.Category;
import Entity.CategoryStatus;

import java.util.List;

public interface ManageElementInterface {
    List<Category> getAllArten();

    List<Category> getAllStimmungen();

    List<Category> getAllObjekte();

    void addElement(Category element, CategoryStatus status);

    void deleteElement(String elementDescription, CategoryStatus status);

    Category getCategoryToDescription(String description, CategoryStatus categoryStatus);
}
