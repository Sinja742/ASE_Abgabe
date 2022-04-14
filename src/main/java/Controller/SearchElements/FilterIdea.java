package Controller.SearchElements;

import Entity.Category;

import java.util.List;

public class FilterIdea extends Filter implements FilterInterface{

    public FilterIdea(Category[] categoryElements, List<Category> allElements) {
        super(categoryElements, allElements);
    }

    @Override
    protected Category filterCategoryElements() {
        return getRandomElement();
    }

}