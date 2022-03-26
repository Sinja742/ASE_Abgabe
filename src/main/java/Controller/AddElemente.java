package Controller;

import Entity.Entity;
import Entity.EntityStatus;
import Entity.Tags;
import jobs.TxtWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AddElemente {

    public AddElemente(GUI gui) {
        this.gui = gui;
    }
    GUI gui;

    public void addingElement(String kriterium, List<String> allOptions) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + kriterium + " hinzufügen?";
        if (gui.trueBooleanQuestion(question)) {
            addNewElement(kriterium, allOptions);
        }
    }

    public void addingElement(String kriterium, List<String> objektOptions, List<String> tagsOptions) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + kriterium + " hinzufügen?";
        if (gui.trueBooleanQuestion(question)) {
            addNewElement(kriterium, objektOptions, tagsOptions);
        }
    }

    private void addNewElement(String kriterium, List<String> allOptions ) throws IOException {
        showExistingElements(kriterium, allOptions);
        String element;
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie den Begriff für " + kriterium + " ein: ");
        element = tastatur.readLine();
        TxtWriter.addElement(element, Objects.requireNonNull(getEntityStatus(kriterium)));
    }

//    Hier wird ein Objekt mit gegebenenfalls tags hinzugefügt
    // TODO: mit methode addnewelement zusammenfassen
    private void addNewElement(String kriterium, List<String> allOptions, List<String> tagsOptions ) throws IOException {
        showExistingElements(kriterium, allOptions);
        String element;
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie den Begriff für " + kriterium + " ein: ");
        element = tastatur.readLine();

        if (gui.trueBooleanQuestion("Wollen Sie Tags zu dem Objekt hinzufügen?")){
            element = addingTags(element, tagsOptions);
        }
        TxtWriter.addElement(element, Objects.requireNonNull(getEntityStatus(kriterium)));
    }

    private EntityStatus getEntityStatus(String kriterium) {
        for (EntityStatus status : EntityStatus.values()) {
            if (status.toString().equals(kriterium.toLowerCase(Locale.ROOT))) {
                return status;
            }
        }
        return null;
    }

    private String addingTags(String element, List<String> tagsOptions) throws IOException {
        String[] tagsEntered;
        showExistingElements("Tag",tagsOptions);
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        tagsEntered = tastatur.readLine().split(" ");
        for (String s : tagsEntered) {
            for (Tags tag : Tags.values()) {
                if (tag.toString().equals(s)) {
                    element = element + "," + tag.getId();
                }
            }
        }
        return element;
    }

    private void showExistingElements(String kriterium, List<String> allElements) {
        System.out.println("Diese Elemente des Typs " + kriterium + " existieren bereits:");
        for(String option : allElements) {
            System.out.print(option + " ");
        }
        System.out.println();
    }
}
