package Controller.SearchElements;

import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

import java.io.IOException;
import java.util.List;

public interface SearchElementsInterface {
    Category[] getSearchElements(CategoryStatus categoryStatus, List<Category> allElements) throws IOException;

    Tag[] getSearchTags(List<Tag> allTags) throws IOException;
}
