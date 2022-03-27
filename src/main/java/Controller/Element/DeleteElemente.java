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
import java.util.Locale;
import java.util.Objects;

public class DeleteElemente {
    public DeleteElemente(GUI gui) {
        this.gui = gui;
    }

    GUI gui;

    public void deletingElement(String kriterium, List<Category> allOptions) throws IOException {
        String question = "Wollen Sie ein Element des Typs " + kriterium + " löschen?";
        if (gui.trueBooleanQuestion(question)) {
            deleteElement(kriterium, allOptions);
        }
    }

    public void deleteElement(String kriterium, List<Category> allOptions) throws IOException {
        showExistingElements(kriterium, ManageElement.toStringList(allOptions));
        String element;
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie den Begriff für " + kriterium + " ein, den Sie löschen wollen: ");
        element = tastatur.readLine();
        TxtHandling.deleteElement(element, Objects.requireNonNull(getEntityStatus(kriterium)));
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
            if (status.getStatus().equals(kriterium.toLowerCase(Locale.ROOT))) {
                return status;
            }
        }
        return null;
    }
}
