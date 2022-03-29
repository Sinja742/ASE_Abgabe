package Controller.SearchElements;

import Controller.GUI;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

import java.io.IOException;
import java.util.List;

public class SearchElements {

    private static GUI gui;

    public SearchElements(GUI gui) {
        this.gui = gui;
    }

    public static Category[] getSearchElements(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        String question = "Wollen Sie nach " + categoryStatus.getStatusPlural() + " suchen?";
        if(gui.trueBooleanQuestion(question)) {
            return getFilters(categoryStatus, allElements);
        } else {
            return new Category[0];
        }
    }

    public static Tag[] getSearchTags(List<Tag> allTags) throws IOException {
        String question = "Wollen Sie nach Tags suchen?";
        if(gui.trueBooleanQuestion(question)) {
            return gui.getTags(allTags);
        } else {
            return new Tag[0];
        }
    }

    private static Category[] getFilters(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        String[] filtersString = gui.getStringArrayOfElements(categoryStatus, allElements,"Geben Sie die gewünschten " + categoryStatus.getStatusPlural() + " ein: ");
        Category[] filters = new Category[filtersString.length];
        for(int countFilter = 0; countFilter < filtersString.length; countFilter++) {
            filters[countFilter] = new Category(filtersString[countFilter]);
        }
        return filters;
    }
}
