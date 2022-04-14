package Controller;

import Controller.Element.AddElement;
import Controller.Element.DeleteElement;
import Controller.Element.UpdateElement;
import Controller.SearchElements.Idea;
import Entity.CategoryStatus;
import jobs.EntityBuilder;

import java.io.IOException;

public class Steuerung {

    public static void main(String[] args) {
        gui = new GUI();
        manageElement = new ManageElement(new EntityBuilder());

        addElemente = new AddElement(gui, manageElement);
        updateElemente = new UpdateElement(gui, manageElement);
        deleteElemente = new DeleteElement(gui, manageElement);

        while (true) {
            userIneraction();
        }
    }

    private static GUI gui;
    private static ManageElement manageElement;
    private static AddElement addElemente;
    private static UpdateElement updateElemente;
    private static DeleteElement deleteElemente;

    private static void userIneraction() {
        try {
            if (gui.trueBooleanQuestion("Wollen Sie nach einer kreativen Idee suchen?")) {
                gui.showIdea((new Idea(gui, manageElement)).toString());
            }
            if (gui.trueBooleanQuestion("Wollen Sie neue Elemente hinzufügen?")) {
                addElementToElementList();
            }
            if (gui.trueBooleanQuestion("Wollen Sie Elemente bearbeiten?")) {
                updateElementInElementList();
            }
            if (gui.trueBooleanQuestion("Wollen Sie Elemente löschen?")) {
                deleteElementFromElementList();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addElementToElementList() throws IOException {
        addElemente.addElement(CategoryStatus.ART, manageElement.getAllArten());
        addElemente.addElement(CategoryStatus.STIMMUNG, manageElement.getAllStimmungen());
        addElemente.addElement(CategoryStatus.OBJEKT, manageElement.getAllObjekte());
    }

    private static void deleteElementFromElementList() throws IOException {
        deleteElemente.deleteElement(CategoryStatus.ART, manageElement.getAllArten());
        deleteElemente.deleteElement(CategoryStatus.STIMMUNG, manageElement.getAllStimmungen());
        deleteElemente.deleteElement(CategoryStatus.OBJEKT, manageElement.getAllObjekte());
    }

    private static void updateElementInElementList() throws IOException {
        updateElemente.updateElement(CategoryStatus.ART, manageElement.getAllArten());
        updateElemente.updateElement(CategoryStatus.STIMMUNG, manageElement.getAllStimmungen());
        updateElemente.updateElement(CategoryStatus.OBJEKT, manageElement.getAllObjekte());
    }

}
