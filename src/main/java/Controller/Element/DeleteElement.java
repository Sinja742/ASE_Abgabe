package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;
import jobs.TxtHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class DeleteElement extends HandlingElement {

    public DeleteElement(GUI gui) {
        this.gui = gui;
    }

    GUI gui;

    public void deletingElement(String kriterium, List<Category> allOptions) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + kriterium + " löschen?";
        if (gui.trueBooleanQuestion(question)) {
            deleteElement(kriterium, allOptions);
        }
    }

    private void deleteElement(String kriterium, List<Category> allOptions) throws IOException {
        String element = handleElement(kriterium, allOptions, "löschen");
        TxtHandling.deleteElement(element, Objects.requireNonNull(CategoryStatus.getCategoryStatus(kriterium)));
    }
}
