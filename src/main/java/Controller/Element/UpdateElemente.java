package Controller.Element;

import Controller.ManageElement;
import Controller.GUI;
import Entity.CategoryStatus;
import jobs.TxtHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class UpdateElemente {
    public UpdateElemente(GUI gui) {
        this.gui = gui;
    }

    GUI gui;

    public void updatingElementFrage(String kriterium, List<String> allOptions) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + kriterium + " bearbeiten?";
        if (gui.trueBooleanQuestion(question)) {
            showExistingElements(kriterium, allOptions);
            updateElement(kriterium);
        }
    }

    public void updatingElementFrage(String kriterium, List<String> objektOptions, List<String> tagsOptions) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + kriterium + " bearbeiten?";
        if (gui.trueBooleanQuestion(question)) {
            showExistingElements(kriterium, objektOptions);
            updateElement(kriterium, tagsOptions);
        }
    }

    public void updateElement(String kriterium) throws IOException {
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welches Element wollen Sie bearbeiten? ");
        TxtHandling.deleteElement(tastatur.readLine(), Objects.requireNonNull(getEntityStatus(kriterium)));
        System.out.println("Geben sie das bearbeitete Element ein: ");
        TxtHandling.addNewElement(tastatur.readLine(), Objects.requireNonNull(getEntityStatus(kriterium)));
    }

    public void updateElement(String kriterium, List<String> tagsOptions) throws IOException {
        String newElement;
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welches Element wollen Sie bearbeiten? ");
        TxtHandling.deleteElement(tastatur.readLine(), Objects.requireNonNull(getEntityStatus(kriterium)));
        System.out.println("Geben sie das bearbeitete Element ein: ");
        newElement = tastatur.readLine();
        TxtHandling.addNewElement(addNewTagsFrage(newElement), Objects.requireNonNull(getEntityStatus(kriterium)));
    }

    public String addNewTagsFrage(String objekt) throws IOException {
        String question = "Wollen Sie Tags zum Objekt " + objekt + " hinzufügen?";
        if (gui.trueBooleanQuestion(question)) {
            return AddElemente.addingTags(objekt, ManageElement.getAllStringTags());
        }else return objekt;
    }

    private void showExistingElements(String kriterium, List<String> allElements) {
        System.out.println("Diese Elemente des Typs " + kriterium + " existieren bereits:");
        for (String option : allElements) {
            System.out.print(option + " ");
        }
        System.out.println();
    }

    private CategoryStatus getEntityStatus(String kriterium) {
        for (CategoryStatus status : CategoryStatus.values()) {
            if (status.toString().equals(kriterium.toLowerCase(Locale.ROOT))) {
                return status;
            }
        }
        return null;
    }

    private void showExistingTagsForObjekt(String element,List<String> tags) {
        System.out.println("Diese tags für " + element + " existieren bereits:");
        for (String option : tags) {
            System.out.print(option + " ");
        }
        System.out.println();
    }
}
