package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.*;

import java.util.List;

public class AddElement extends HandlingElement {

    public AddElement(ManageElement manageElement) {
        super(manageElement);
    }

    //Testing
    public AddElement(GUI gui, ManageElement manageElement) {
        super(gui, manageElement);
    }

    public void addElement(CategoryStatus categoryStatus, List<Category> allElements) {
        String question = "Wollen Sie ein Element des Typs " + categoryStatus.getStatus() + " hinzufügen? ";
        if (gui.trueBooleanQuestion(question)) {
            addNewElementOfTypeCategory(categoryStatus, allElements);
        }
    }

    private void addNewElementOfTypeCategory(CategoryStatus categoryStatus, List<Category> allElements) {
        String newElement = handleElement(categoryStatus, allElements, "neu anlegen");
        if (!this.checkInput.elementDoNotExists(newElement, categoryStatus)) {
            addNewElementOfTypeCategory(categoryStatus, allElements);
        } else {
            saveNewElement(newElement, categoryStatus);
        }
    }

    void saveNewElement(String newElement, CategoryStatus categoryStatus) {
        if (CategoryStatus.OBJEKT.isEqualCategory(categoryStatus)) {
            manageElement.addElement(new Objekt(newElement, addTags(newElement)), categoryStatus);
        } else {
            manageElement.addElement(new SimpleCategory(newElement), categoryStatus);
        }
    }

    public Tag[] addTags(String objektDescription) {
        if (wantAddTags(objektDescription)) {
            return readNewTags();
        }
        return new Tag[0];
    }

    boolean wantAddTags(String objektDescription) {
        String question = "Wollen Sie Tags zum Objekt " + objektDescription + " hinzufügen? ";
        return gui.trueBooleanQuestion(question);
    }

    Tag[] readNewTags() {
        return gui.getTags();
    }
}