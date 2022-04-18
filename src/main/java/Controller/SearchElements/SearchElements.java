package Controller.SearchElements;

import Controller.CheckInput;
import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

import java.util.List;

public class SearchElements implements SearchElementsInterface {

    private final GUI gui;
    private final ManageElement manageElement;
    private final CheckInput checkInput;

    public SearchElements(GUI gui, ManageElement manageElement) {
        this.gui = gui;
        this.manageElement = manageElement;
        this.checkInput = new CheckInput(this.manageElement);
    }

    public Category[] getSearchElements(CategoryStatus categoryStatus, List<Category> allElements) {
        String question = "Wollen Sie nach " + categoryStatus.getStatusPlural() + " suchen?";
        if (gui.trueBooleanQuestion(question)) {
            return getFilters(categoryStatus, allElements);
        } else {
            return new Category[0];
        }
    }

    public Tag[] getSearchTags(){
        String question = "Wollen Sie nach Tags suchen?";
        if(gui.trueBooleanQuestion(question)) {
            return gui.getTags();
        } else {
            return new Tag[0];
        }
    }

    Category[] getFilters(CategoryStatus categoryStatus, List<Category> allElements) {
        String[] filtersString = gui.getStringArrayOfElements(categoryStatus, allElements, "Geben Sie die gewünschten " + categoryStatus.getStatusPlural() + " ein: ");
        if (!this.checkInput.checkCategoriesExist(filtersString,categoryStatus)){
            return getFilters(categoryStatus,allElements);
        }
        Category[] filters = new Category[filtersString.length];
        for(int countFilter = 0; countFilter < filtersString.length; countFilter++) {
            filters[countFilter] = manageElement.getCategoryToDescription(filtersString[countFilter], categoryStatus);
        }
        return filters;
    }
}
