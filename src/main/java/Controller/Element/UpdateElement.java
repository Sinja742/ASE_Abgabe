package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;

import java.io.IOException;
import java.util.List;

public class UpdateElement extends HandlingElement {

    public UpdateElement(GUI gui, ManageElement manageElement) {
        super(gui, manageElement);
    }

    public void updateElement(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + categoryStatus.getStatus() + " bearbeiten?";
        if (gui.trueBooleanQuestion(question)) {
            updateElementOfTypeCategory(categoryStatus, allElements);
        }
    }

//    Verhaltensmuster Update = delete + new
    public void updateElementOfTypeCategory(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        String element = handleElement(categoryStatus, allElements, "bearbeiten");
        manageElement.deleteElement(element, categoryStatus);
        new AddElement(gui, manageElement).saveNewElement(gui.getNewElement(categoryStatus), categoryStatus);
    }
}
