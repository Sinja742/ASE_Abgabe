package Controller;

import Controller.Element.AddElement;
import Controller.Element.DeleteElement;
import Controller.Element.UpdateElement;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Steuerung {

    public static void main(String[] args) throws IOException {
        gui = new GUI();
        new ManageElement();
        idea = new Idea(gui);

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
    private static Idea idea;

    private static Category[] artFilter;
    private static Category[] stimmungFilter;
    private static Category[] objektFilter;
    private static Tag[] tagFilter;

    private static void userIneraction(AddElement addElemente, UpdateElement updateElemente, DeleteElement deleteElemente) throws IOException {
        try {
            if (gui.trueBooleanQuestion("Wollen Sie nach einer kreativen Idee suchen?")) {
                idea.searchIdea();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        // <<


        private static void addElementToElementList () {
            addElemente.addElement(CategoryStatus.ART, ManageElement.getAllArten());
            addElemente.addElement(CategoryStatus.STIMMUNG, ManageElement.getAllStimmungen());
            addElemente.addElement(CategoryStatus.OBJEKT, ManageElement.getAllObjekte());
        }

        private static void deleteElementFromElementList () {
            try {
                deleteElemente.deleteElement(CategoryStatus.ART, ManageElement.getAllArten());
                deleteElemente.deleteElement(CategoryStatus.STIMMUNG, ManageElement.getAllStimmungen());
                deleteElemente.deleteElement(CategoryStatus.OBJEKT, ManageElement.getAllObjekte());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void updateElementInElementList () {
            try {
                updateElemente.updateElement(CategoryStatus.ART, ManageElement.getAllArten());
                updateElemente.updateElement(CategoryStatus.STIMMUNG, ManageElement.getAllStimmungen());
                updateElemente.updateElement(CategoryStatus.OBJEKT, ManageElement.getAllObjekte());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void filterObjekteIfTag () {
            if (!filterEmpty(tagFilter)) {
                filterObjekte();
            }
        }

        private static void filterObjekte () {
            List<Category> objekte = new ArrayList<>();
            for (Category category : objektFilter) {
                if (category.containsTag(tagFilter)) {
                    objekte.add(category);
                }
            }
            System.out.println("Listengröße " + objekte.size());
            objektFilter = ManageElement.toArray(objekte);
        }

        private static String getIdea () {
            filterObjekteIfTag();
            if (filterEmpty(objektFilter)) {
                return "\nEs gibt keine Objekte zu den ausgewählten Tags. Bitte weniger Tags setzen für eine Idee.";
            } else {
                return randomOptions();
            }
        }

        private static String randomOptions () {
            String idea;
            idea = randomFilterOption(artFilter);
            idea = idea.concat(" " + randomFilterOption(stimmungFilter));
            idea = idea.concat(" " + randomFilterOption(objektFilter));

            return idea;
        }

        private static String randomFilterOption (Category[]filter){
            return filter[(int) (Math.random() * filter.length)].getDescription();
        }

        private static void fillEmptyFilter () {
            if (filterEmpty(artFilter)) {
                artFilter = ManageElement.toArray(ManageElement.getAllArten());
            }
            if (filterEmpty(stimmungFilter)) {
                stimmungFilter = ManageElement.toArray(ManageElement.getAllStimmungen());
            }
            if (filterEmpty(objektFilter)) {
                objektFilter = ManageElement.toArray(ManageElement.getAllObjekte());
            }
        }

        private static boolean filterEmpty (Category[]filter){
            return filter.length == 0;
        }

        private static boolean filterEmpty (Tag[]filter){
            return filter.length == 0;
        }

    }
