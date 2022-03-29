package Controller.SearchElements;

import Controller.ManageElement;
import Entity.Category;

import java.util.List;

public abstract class Filter {

    protected static Category[] categoryElements;
    protected static List<Category> allElements;

    public Filter(Category[] categoryElements, List<Category> allElements) {
        this.categoryElements = categoryElements;
        this.allElements = allElements;
    }

    public Category random() {
        fillCategoryElementsIfEmpty();
        return filterCategoryElements();
    }

    protected static void fillCategoryElementsIfEmpty() {
        if (noFilterElements(categoryElements)) {
            categoryElements = ManageElement.toArray(allElements);
        }
    }

    protected abstract Category filterCategoryElements();

    protected static Category getRandomElement() {
        return categoryElements[(int) (Math.random() * categoryElements.length)];
    }

    protected static boolean noFilterElements(Category[] filter) {
        return filter.length == 0;
    }

}
