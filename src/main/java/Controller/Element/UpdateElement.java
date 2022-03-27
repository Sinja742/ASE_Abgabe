package Controller.Element;

import Controller.GUI;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;
import jobs.TxtHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class UpdateElement extends HandlingElement {

    public UpdateElement(GUI gui) {
        this.gui = gui;
    }

    GUI gui;

    public void updatingElement(String kriterium, List<Category> allOptions) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + kriterium + " bearbeiten?";
        if (gui.trueBooleanQuestion(question)) {
            updateElement(kriterium, allOptions);
        }
    }

    public void updateElement(String kriterium, List<Category> allOptions) throws IOException {
        String element = handleElement(kriterium, allOptions, "bearbeiten");
        TxtHandling.deleteElement(element, Objects.requireNonNull(CategoryStatus.getCategoryStatus(kriterium)));
        String newElement = getNewElement();
        if (CategoryStatus.OBJEKT.isEqualCategory(kriterium)) {
            TxtHandling.addNewElement(addNewTagsFrage(newElement), Objects.requireNonNull(CategoryStatus.getCategoryStatus(kriterium)));
        } else {
            TxtHandling.addNewElement(newElement, Objects.requireNonNull(CategoryStatus.getCategoryStatus(kriterium)));
        }
    }

    public String addNewTagsFrage(String objekt) throws IOException {
        String question = "Wollen Sie Tags zum Objekt " + objekt + " hinzufügen?";
        if (gui.trueBooleanQuestion(question)) {
            return AddElement.addingTags(objekt);
        } else return objekt;
    }
}
