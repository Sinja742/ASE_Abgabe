package Controller;

import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

import java.util.List;

public interface GUIInterface {
    void showIdea(String idea);

    boolean trueBooleanQuestion(String question);

    String[] getStringArrayOfElements(CategoryStatus categoryStatus, List<Category> allElements, String text);

    Tag[] getTags();

    String[] getTagsString();

    void showExistingElements(String categoryStatus, List<String> allElements);

    String getNewElement(CategoryStatus categoryStatus);
}
