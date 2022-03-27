package Controller.Element;

import Controller.GUI;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;
import jobs.TxtHandling;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class AddElement extends HandlingElement {

    public AddElement(GUI gui) {
        super(gui);
    }

    public void addElement(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        try {
            String question = "Wollen Sie ein Element des Typs " + categoryStatus.getStatus() + " hinzufügen? ";
            if (gui.trueBooleanQuestion(question)) {
                addNewElementOfTypeCategory(categoryStatus, allElements);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void addNewElementOfTypeCategory(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        try {
            String newElement = handleElement(categoryStatus, allElements, "neu anlegen");
            if (CategoryStatus.OBJEKT.isEqualCategory(categoryStatus)) {
                TxtHandling.addNewElement(addTags(newElement), categoryStatus);
            } else {
                TxtHandling.addNewElement(newElement, categoryStatus);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String addTags(String objektDescription) throws IOException {
        try {
            if (wantAddTags(objektDescription)) {
                return readNewTags(objektDescription);
            }
            return objektDescription;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    private static boolean wantAddTags(String objektDescription) throws IOException {

        try {
            String question = "Wollen Sie Tags zum Objekt " + objektDescription + " hinzufügen? ";
            return gui.trueBooleanQuestion(question);
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    private static String readNewTags(String objektDescription) throws IOException {
        try {
            Tag[] tagsEntered = GUI.getTags(Tag.getAllTags());
            for (Tag tag : tagsEntered) {
                objektDescription = objektDescription.concat("," + tag);
            }
            return objektDescription;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}