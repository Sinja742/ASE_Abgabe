package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Objekt;
import Entity.SimpleCategory;

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
        String newElement = gui.getNewElement();
        if (CategoryStatus.OBJEKT.isEqualCategory(categoryStatus)) {
            manageElement.addElement(new Objekt(newElement, new AddElement(this.gui, this.manageElement).addTags(newElement)), categoryStatus);
        } else {
            manageElement.addElement(new SimpleCategory(newElement), categoryStatus);
        }
    }
}
