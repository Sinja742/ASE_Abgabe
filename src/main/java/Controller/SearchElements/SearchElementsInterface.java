package Controller.SearchElements;

import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

import java.util.List;

public interface SearchElementsInterface {
    Category[] getSearchElements(CategoryStatus categoryStatus, List<Category> allElements);

    Tag[] getSearchTags(List<Tag> allTags);
}
