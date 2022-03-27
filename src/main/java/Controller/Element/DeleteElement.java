package Controller.Element;

import Controller.GUI;
import Entity.Category;
import Entity.CategoryStatus;
import jobs.TxtHandling;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class DeleteElement extends HandlingElement {

    public DeleteElement(GUI gui) {
        super(gui);
    }

    public void deleteElement(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + categoryStatus.getStatus() + " löschen?";
        if (gui.trueBooleanQuestion(question)) {
            deleteElementOfTypeCategory(categoryStatus, allElements);
        }
    }

    private void deleteElementOfTypeCategory(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        String element = handleElement(categoryStatus, allElements, "löschen");
        TxtHandling.deleteElement(element, categoryStatus);
    }
}
