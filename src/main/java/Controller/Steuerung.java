package Controller;

import Controller.Element.AddElement;
import Controller.Element.DeleteElement;
import Controller.Element.UpdateElement;
import Controller.SearchElements.Idea;
import Entity.CategoryStatus;

import java.io.IOException;


public class Steuerung {

    public static void main(String[] args) throws IOException {
        gui = new GUI();
        new ManageElement();

        addElemente = new AddElement(gui);
        updateElemente = new UpdateElement(gui);
        deleteElemente = new DeleteElement(gui);

        while (true) {
            userIneraction();
        }
    }

    private static GUI gui;
    private static AddElement addElemente;
    private static UpdateElement updateElemente;
    private static DeleteElement deleteElemente;

    private static void userIneraction() throws IOException {
        if (gui.trueBooleanQuestion("Wollen Sie nach einer kreativen Idee suchen?")) {
            gui.showIdea((new Idea(gui)).toString());
        }
        if (gui.trueBooleanQuestion("Wollen Sie neue Elemente hinzufügen?")) {
            addElementToElementList();
            ManageElement.reloadElements();
        }
        if (gui.trueBooleanQuestion("Wollen Sie Elemente bearbeiten?")) {
            updateElementInElementList();
            ManageElement.reloadElements();
        }
        if (gui.trueBooleanQuestion("Wollen Sie Elemente löschen?")) {
            deleteElementFromElementList();
            ManageElement.reloadElements();
        }
    }

    private static void addElementToElementList() throws IOException {
        addElemente.addElement(CategoryStatus.ART, ManageElement.getAllArten());
        addElemente.addElement(CategoryStatus.STIMMUNG, ManageElement.getAllStimmungen());
        addElemente.addElement(CategoryStatus.OBJEKT, ManageElement.getAllObjekte());
    }

    private static void deleteElementFromElementList() throws IOException {
        deleteElemente.deleteElement(CategoryStatus.ART, ManageElement.getAllArten());
        deleteElemente.deleteElement(CategoryStatus.STIMMUNG, ManageElement.getAllStimmungen());
        deleteElemente.deleteElement(CategoryStatus.OBJEKT, ManageElement.getAllObjekte());
    }

    private static void updateElementInElementList() throws IOException {
        updateElemente.updateElement(CategoryStatus.ART, ManageElement.getAllArten());
        updateElemente.updateElement(CategoryStatus.STIMMUNG, ManageElement.getAllStimmungen());
        updateElemente.updateElement(CategoryStatus.OBJEKT, ManageElement.getAllObjekte());
    }

}
