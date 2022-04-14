package Controller.Element;

import Controller.GUI;
import Entity.Category;
import Entity.CategoryStatus;
import jobs.TxtHandling;

import java.io.IOException;
import java.util.List;

public class UpdateElement extends HandlingElement {

    public UpdateElement(GUI gui) {
        super(gui);
    }

    public void updateElement(CategoryStatus categoryStatus, List<Category> allElements){
        String question = "Wollen Sie ein Element des Typs " + categoryStatus.getStatus() + " bearbeiten?";
        if (gui.trueBooleanQuestion(question)) {
            updateElementOfTypeCategory(categoryStatus, allElements);
        }
    }

    public void updateElementOfTypeCategory(CategoryStatus categoryStatus, List<Category> allElements){
        String element = handleElement(categoryStatus, allElements, "bearbeiten");
        TxtHandling.deleteElement(element, categoryStatus);
        String newElement = gui.getNewElement();
        if (CategoryStatus.OBJEKT.isEqualCategory(categoryStatus)) {
            TxtHandling.addNewElement(AddElement.addTags(newElement), categoryStatus);
        } else {
            TxtHandling.addNewElement(newElement, categoryStatus);
        }
    }
}
