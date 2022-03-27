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

        AddElement addElemente = new AddElement(gui);
        UpdateElement updateElemente = new UpdateElement(gui);
        DeleteElement deleteElemente = new DeleteElement(gui);

        while (true) {
            userIneraction(addElemente, updateElemente, deleteElemente);
        }
    }

    private static GUI gui;


    private static Category[] artFilter;
    private static Category[] stimmungFilter;
    private static Category[] objektFilter;
    private static Tag[] tagFilter;

    private static void userIneraction(AddElement addElemente, UpdateElement updateElemente, DeleteElement deleteElemente) throws IOException {
        if (gui.trueBooleanQuestion("Wollen Sie nach einer kreativen Idee suchen?")) {
            searchIdea();
        }
        if (gui.trueBooleanQuestion("Wollen Sie neue Elemente hinzufügen?")) {
            addElementToElementList(addElemente);
            ManageElement.reloadElements();
        }
        if (gui.trueBooleanQuestion("Wollen Sie Elemente bearbeiten?")) {
            updateElementInElementList(updateElemente);
            ManageElement.reloadElements();
        }
        if (gui.trueBooleanQuestion("Wollen Sie Elemente löschen?")) {
            deleteElementFromElementList(deleteElemente);
            ManageElement.reloadElements();
        }
    }

    private static void searchIdea() throws IOException {
        getAllSearchOpportiunities();
        gui.showIdea(getIdea());
    }

    private static void getAllSearchOpportiunities() throws IOException {
        artFilter = gui.getSearchOpportiunities(CategoryStatus.ART.getStatusPlural(), ManageElement.getAllArten());
        stimmungFilter = gui.getSearchOpportiunities(CategoryStatus.STIMMUNG.getStatusPlural(), ManageElement.getAllStimmungen());
        objektFilter = gui.getSearchOpportiunities(CategoryStatus.OBJEKT.getStatusPlural(), ManageElement.getAllObjekte());
        tagFilter = gui.getSearchTags(Tag.getAllTags());

        fillEmptyFilter();
    }

    private static void addElementToElementList(AddElement addElemente) throws IOException {
        addElemente.addingElement(CategoryStatus.ART.getStatus(), ManageElement.getAllArten());
        addElemente.addingElement(CategoryStatus.STIMMUNG.getStatus(), ManageElement.getAllStimmungen());
        addElemente.addingElement(CategoryStatus.OBJEKT.getStatus(), ManageElement.getAllObjekte());
    }

    private static void deleteElementFromElementList(DeleteElement deleteElemente) throws IOException {
        deleteElemente.deletingElement(CategoryStatus.ART.getStatus(), ManageElement.getAllArten());
        deleteElemente.deletingElement(CategoryStatus.STIMMUNG.getStatus(), ManageElement.getAllStimmungen());
        deleteElemente.deletingElement(CategoryStatus.OBJEKT.getStatus(), ManageElement.getAllObjekte());
    }

    private static void updateElementInElementList(UpdateElement updateElemente) throws IOException {
        updateElemente.updatingElement(CategoryStatus.ART.getStatus(), ManageElement.getAllArten());
        updateElemente.updatingElement(CategoryStatus.STIMMUNG.getStatus(), ManageElement.getAllStimmungen());
        updateElemente.updatingElement(CategoryStatus.OBJEKT.getStatus(), ManageElement.getAllObjekte());
    }

    private static void filterObjekteIfTag() {
        if (!filterEmpty(tagFilter)) {
            filterObjekte();
        }
    }

    private static void filterObjekte() {
        List<Category> objekte = new ArrayList<>();
        for (Category category : objektFilter) {
            if (category.containsTag(tagFilter)) {
                objekte.add(category);
            }
        }
        System.out.println("Listengröße " + objekte.size());
        objektFilter = ManageElement.toArray(objekte);
    }

    private static String getIdea() {
        filterObjekteIfTag();
        if (filterEmpty(objektFilter)) {
            return "\nEs gibt keine Objekte zu den ausgewählten Tags. Bitte weniger Tags setzen für eine Idee.";
        } else {
            return randomOptions();
        }
    }

    private static String randomOptions() {
        String idea;
        idea = randomFilterOption(artFilter);
        idea = idea.concat(" " + randomFilterOption(stimmungFilter));
        idea = idea.concat(" " + randomFilterOption(objektFilter));

        return idea;
    }

    private static String randomFilterOption(Category[] filter) {
        return filter[(int) (Math.random() * filter.length)].getDescription();
    }

    private static void fillEmptyFilter() {
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

    private static boolean filterEmpty(Category[] filter) {
        return filter.length == 0;
    }

    private static boolean filterEmpty(Tag[] filter) {
        return filter.length == 0;
    }

}
