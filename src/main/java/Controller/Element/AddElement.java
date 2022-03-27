package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;
import jobs.TxtHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AddElement extends HandlingElement {

    public AddElement(GUI gui) {
        this.gui = gui;
    }

    GUI gui;

    public void addingElement(String kriterium, List<Category> allOptions) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + kriterium + " hinzufügen?";
        if (gui.trueBooleanQuestion(question)) {
            addNewElement(kriterium, allOptions);
        }
    }

    private void addNewElement(String kriterium, List<Category> allOptions) throws IOException {
        String newElement = handleElement(kriterium, allOptions, "neu anlegen");
        if (CategoryStatus.OBJEKT.isEqualCategory(kriterium)) {
            TxtHandling.addNewElement(addingTags(newElement), Objects.requireNonNull(CategoryStatus.getCategoryStatus(kriterium)));
        } else {
            TxtHandling.addNewElement(newElement, Objects.requireNonNull(CategoryStatus.getCategoryStatus(kriterium)));
        }
    }

    public static String addingTags(String element) throws IOException {
        Tag[] tagsEntered = GUI.getTags(Tag.getAllTags());
        for (Tag tag : tagsEntered) {
            element = element.concat("," + tag);
        }
        return element;
    }
}