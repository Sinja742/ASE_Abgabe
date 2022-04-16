package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;

import java.util.List;

public class DeleteElement extends HandlingElement {

    public DeleteElement(GUI gui, ManageElement manageElement) {
        super(gui, manageElement);
    }

    public void deleteElement(CategoryStatus categoryStatus, List<Category> allElements) {
        String question = "Wollen Sie ein Element des Typs " + categoryStatus.getStatus() + " löschen?";
        if (gui.trueBooleanQuestion(question)) {
            deleteElementOfTypeCategory(categoryStatus, allElements);
        }
    }

    private void deleteElementOfTypeCategory(CategoryStatus categoryStatus, List<Category> allElements) {
        String element = handleElement(categoryStatus, allElements, "löschen");
        if (!this.checkInput.checkCategoriesExist(new String[]{element}, categoryStatus)) {
            deleteElementOfTypeCategory(categoryStatus, allElements);
        } else {
            manageElement.deleteElement(element, categoryStatus);
        }

    }
}
