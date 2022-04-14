package Controller.SearchElements;

import Controller.GUI;
import Controller.ManageElement;
import Entity.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchElements implements SearchElementsInterface{

    private final GUI gui;
    private final ManageElement manageElement;

    public SearchElements(GUI gui, ManageElement manageElement) {
        this.gui = gui;
        this.manageElement = manageElement;
    }

    public Category[] getSearchElements(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        String question = "Wollen Sie nach " + categoryStatus.getStatusPlural() + " suchen?";
        if(gui.trueBooleanQuestion(question)) {
            return getFilters(categoryStatus, allElements);
        } else {
            return new Category[0];
        }
    }

    public Tag[] getSearchTags() throws IOException {
        String question = "Wollen Sie nach Tags suchen?";
        if(gui.trueBooleanQuestion(question)) {
            return gui.getTags();
        } else {
            return new Tag[0];
        }
    }

    private Category[] getFilters(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        String[] filtersString = gui.getStringArrayOfElements(categoryStatus, allElements,"Geben Sie die gewünschten " + categoryStatus.getStatusPlural() + " ein: ");
        Category[] filters = new Category[filtersString.length];
        for(int countFilter = 0; countFilter < filtersString.length; countFilter++) {
            filters[countFilter] = manageElement.getCategoryToDescription(filtersString[countFilter], categoryStatus);
        }
        return filters;
    }
}
