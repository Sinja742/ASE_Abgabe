package Controller;

import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

import java.io.IOException;
import java.util.List;

public interface GUIInterface {
    void showIdea(String idea);

    boolean trueBooleanQuestion(String question) throws IOException;

    String[] getStringArrayOfElements(CategoryStatus categoryStatus, List<Category> allElements, String text) throws IOException;

    Tag[] getTags() throws IOException;

    String[] getTagsString() throws IOException;

    void showExistingElements(String categoryStatus, List<String> allElements);

    String getNewElement(CategoryStatus categoryStatus) throws IOException;
}
