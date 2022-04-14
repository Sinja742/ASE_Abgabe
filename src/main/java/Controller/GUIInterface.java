package Controller;

import Entity.Category;
import Entity.CategoryStatus;

import java.io.IOException;
import java.util.List;

public interface GUIInterface {
    void showIdea(String idea);

    boolean trueBooleanQuestion(String question) throws IOException;

    String[] getStringArrayOfElements(CategoryStatus categoryStatus, List<Category> allElements, String text) throws IOException;

    String getNewElement() throws IOException;
}
