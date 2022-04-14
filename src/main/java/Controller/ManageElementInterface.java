package Controller;

import Entity.Category;
import Entity.CategoryStatus;

import java.io.IOException;
import java.util.List;

public interface ManageElementInterface {
    List<Category> getAllArten();

    List<Category> getAllStimmungen();

    List<Category> getAllObjekte();

    void addElement(Category element, CategoryStatus status) throws IOException;

    void deleteElement(String elementDescription, CategoryStatus status) throws IOException;

    Category getCategoryToDescription(String description, CategoryStatus categoryStatus);
}
