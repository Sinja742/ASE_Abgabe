package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.*;

import java.io.IOException;
import java.util.List;

public class AddElement extends HandlingElement {

    public AddElement(GUI gui, ManageElement manageElement) {
        super(gui, manageElement);
    }

    public void addElement(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + categoryStatus.getStatus() + " hinzufügen? ";
        if (gui.trueBooleanQuestion(question)) {
            addNewElementOfTypeCategory(categoryStatus, allElements);
        }
    }

    private void addNewElementOfTypeCategory(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        String newElement = handleElement(categoryStatus, allElements, "neu anlegen");
        saveNewElement(newElement, categoryStatus);
    }

    void saveNewElement(String newElement, CategoryStatus categoryStatus) throws IOException {
        if (CategoryStatus.OBJEKT.isEqualCategory(categoryStatus)) {
            manageElement.addElement(new Objekt(newElement, addTags(newElement)), categoryStatus);
        } else {
            manageElement.addElement(new SimpleCategory(newElement), categoryStatus);
        }
    }

    public Tag[] addTags(String objektDescription) throws IOException {
        if (wantAddTags(objektDescription)) {
            return readNewTags();
        }
        return new Tag[0];
    }

    private boolean wantAddTags(String objektDescription) throws IOException {
        String question = "Wollen Sie Tags zum Objekt " + objektDescription + " hinzufügen? ";
        return gui.trueBooleanQuestion(question);
    }

    private Tag[] readNewTags() throws IOException {
        return gui.getTags(Tag.getAllTags());
    }
}