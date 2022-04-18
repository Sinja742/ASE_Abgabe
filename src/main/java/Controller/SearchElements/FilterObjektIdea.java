package Controller.SearchElements;

import Controller.ManageElement;
import Entity.Category;
import Entity.Tag;

import java.util.ArrayList;
import java.util.List;

public class FilterObjektIdea extends Filter implements FilterInterface{

    private Tag[] tagFilter;

    public FilterObjektIdea(Category[] categoryElements, List<Category> allElements, Tag[] tagFilter) {
        super(categoryElements, allElements);
        this.tagFilter = tagFilter;
    }

    @Override
    Category filterCategoryElements() {
        filterElementsIfTag();
        if (!noFilterElements(categoryElements)) {
            return getRandomElement();
        } else {
            System.out.println("Es gibt keine Objekte zu den ausgewählten Tags. Bitte weniger Tags setzen für eine Idee." );
            return null;
        }
    }

    void filterElementsIfTag() {
        if (tagFilterExists(tagFilter)) {
            filterObjekte();
        }
    }

    void filterObjekte() {
        List<Category> objekte = new ArrayList<>();
        for (Category category : categoryElements) {
            if (category.containsTag(tagFilter)) {  //return false
                objekte.add(category);
            }
        }
        categoryElements = ManageElement.toArray(objekte);
    }

    boolean tagFilterExists(Tag[] filter) {
        return filter.length > 0;
    }
}
