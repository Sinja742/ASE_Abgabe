package Controller.Element;

import Controller.GUI;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;
import jobs.TxtHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AddElemente {

    public AddElemente(GUI gui) {
        this.gui = gui;
    }

    GUI gui;

    public void addingElement(String kriterium, List<Category> allOptions) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + kriterium + " hinzufügen?";
        if (gui.trueBooleanQuestion(question)) {
            addNewElement(kriterium, allOptions);
        }
    }

    public void addingElement(String kriterium, List<Category> objektOptions, List<Tag> tagsOptions) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + kriterium + " hinzufügen?";
        if (gui.trueBooleanQuestion(question)) {
            addNewElement(kriterium, objektOptions, tagsOptions);
        }
    }

    private void addNewElement(String kriterium, List<Category> allOptions) throws IOException {
        showExistingElements(kriterium, List.of(allOptions.toString()));
        String element;
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie den Begriff für " + kriterium + " ein: ");
        element = tastatur.readLine();
        TxtHandling.addNewElement(element, Objects.requireNonNull(getEntityStatus(kriterium)));
    }

    //    Hier wird ein Objekt mit gegebenenfalls tags hinzugefügt
    // TODO: mit methode addnewelement zusammenfassen
    private void addNewElement(String kriterium, List<Category> allOptions, List<Tag> tagsOptions) throws IOException {
        showExistingElements(kriterium, List.of(allOptions.toString()));
        String element;
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie den Begriff für " + kriterium + " ein: ");
        element = tastatur.readLine();

        if (gui.trueBooleanQuestion("Wollen Sie Tags zu dem Objekt hinzufügen?")) {
            element = addingTags(element, tagsOptions);
        }
        TxtHandling.addNewElement(element, Objects.requireNonNull(getEntityStatus(kriterium)));
    }

    private CategoryStatus getEntityStatus(String kriterium) {
        for (CategoryStatus status : CategoryStatus.values()) {
            if (status.getStatus().equals(kriterium.toLowerCase(Locale.ROOT))) {
                return status;
            }
        }
        return null;
    }

    public static String addingTags(String element, List<Tag> tagsOptions) throws IOException {
        String[] tagsEntered;
        showExistingElements("Tag", List.of(tagsOptions.toString()));
        System.out.println("Geben Sie die entsprechenden Tags an: ");
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        tagsEntered = tastatur.readLine().split(" ");
        StringBuilder elementBuilder = new StringBuilder(element);
        for (String s : tagsEntered) {
            for (Tag tag : Tag.values()) {
                if (tag.getDescription().equals(s)) {
                    elementBuilder.append(",").append(tag.getId());
                }
            }
        }
        element = elementBuilder.toString();
        return element;
    }

    private static void showExistingElements(String kriterium, List<String> allElements) {
        System.out.println("Diese Elemente des Typs " + kriterium + " existieren bereits:");
        for (String option : allElements) {
            System.out.print(option + " ");
        }
        System.out.println();
    }
}
