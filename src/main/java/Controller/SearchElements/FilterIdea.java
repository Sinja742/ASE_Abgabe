package Controller.SearchElements;

import Entity.Category;
import Entity.CategoryStatus;

import java.util.List;

public class FilterIdea extends Filter{

    public FilterIdea(Category[] categoryElements, List<Category> allElements) {
        super(categoryElements, allElements);
    }

    @Override
    protected Category filterCategoryElements() {
        return getRandomElement();
    }

}
