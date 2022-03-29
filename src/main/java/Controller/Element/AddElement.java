package Controller.Element;

import Controller.GUI;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;
import jobs.TxtHandling;

import java.io.IOException;
import java.util.List;

public class AddElement extends HandlingElement {

    public AddElement(GUI gui) {
        super(gui);
    }

    public void addElement(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + categoryStatus.getStatus() + " hinzufügen? ";
        if (gui.trueBooleanQuestion(question)) {
            addNewElementOfTypeCategory(categoryStatus, allElements);
        }
    }

    private void addNewElementOfTypeCategory(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        String newElement = handleElement(categoryStatus, allElements, "neu anlegen");
        if (CategoryStatus.OBJEKT.isEqualCategory(categoryStatus)) {
            TxtHandling.addNewElement(addTags(newElement), categoryStatus);
        } else {
            TxtHandling.addNewElement(newElement, categoryStatus);
        }
    }

    public static String addTags(String objektDescription) throws IOException {
        if (wantAddTags(objektDescription)) {
            return readNewTags(objektDescription);
        }
        return objektDescription;
    }

    private static boolean wantAddTags(String objektDescription) throws IOException {
        String question = "Wollen Sie Tags zum Objekt " + objektDescription + " hinzufügen? ";
        return gui.trueBooleanQuestion(question);
    }

    private static String readNewTags(String objektDescription) throws IOException {
        Tag[] tagsEntered = GUI.getTags(Tag.getAllTags());
        for (Tag tag : tagsEntered) {
            objektDescription = objektDescription.concat("," + tag);
        }
        return objektDescription;
    }
}