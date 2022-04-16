package Controller.SearchElements;

import Controller.ManageElement;
import Entity.Category;

import java.util.List;

public abstract class Filter implements FilterInterface{

    protected Category[] categoryElements;
    protected List<Category> allElements;

    public Filter(Category[] categoryElements, List<Category> allElements) {
        this.categoryElements = categoryElements;
        this.allElements = allElements;
    }

    public Category random() {
        fillCategoryElementsIfEmpty();
        return filterCategoryElements();
    }

    void fillCategoryElementsIfEmpty() {
        if (noFilterElements(categoryElements)) {
            categoryElements = ManageElement.toArray(allElements);
        }
    }

    abstract Category filterCategoryElements();

    Category getRandomElement() {
        return categoryElements[(int) (Math.random() * categoryElements.length)];
    }

    boolean noFilterElements(Category[] filter) {
        return filter.length == 0;
    }

}
