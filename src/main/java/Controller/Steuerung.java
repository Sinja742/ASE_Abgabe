package Controller;

import Controller.Element.AddElemente;
import Controller.Element.DeleteElemente;
import Controller.Element.UpdateElemente;
import Entity.Category;

import java.io.IOException;
import java.util.List;

public class Steuerung {

    public static void main(String[] args) throws IOException {
        gui = new GUI();
        new ManageElement();

        AddElemente addElemente = new AddElemente(gui);
        UpdateElemente updateElemente = new UpdateElemente(gui);
        DeleteElemente deleteElemente = new DeleteElemente(gui);

        while (true) {
            userIneraction(addElemente, updateElemente, deleteElemente);
        }
    }

    private static GUI gui;


    private static String[] artFilter;
    private static String[] stimmungFilter;
    private static String[] objektFilter;
    private static String[] tagFilter;

    private static void userIneraction(AddElemente addElemente, UpdateElemente updateElemente, DeleteElemente deleteElemente) throws IOException {
        if (gui.trueBooleanQuestion("Wollen Sie nach einer kreativen Idee suchen?")) {
            searchIdea();
        }
        if (gui.trueBooleanQuestion("Wollen Sie neue Elemente hinzufügen?")) {
            addWordToElementeList(addElemente);
        }
        if (gui.trueBooleanQuestion("Wollen Sie Elemente bearbeiten?")) {
            updateWordInElementeList(updateElemente);
        }
        if (gui.trueBooleanQuestion("Wollen Sie Elemente löschen?")) {
            deleteWordFromElementeList(deleteElemente);
        }
    }

    private static void searchIdea() throws IOException {
        getAllSearchOpportiunities();
        gui.showIdea(getIdea());
    }

    private static void getAllSearchOpportiunities() throws IOException {
        artFilter = gui.getSearchOpportiunities("Arten", ManageElement.getAllStringArten());
        stimmungFilter = gui.getSearchOpportiunities("Stimmungen", ManageElement.getAllStringStimmungen());
        objektFilter = gui.getSearchOpportiunities("Objekte", ManageElement.getAllStringObjekte());
        tagFilter = gui.getSearchOpportiunities("Tags", ManageElement.getAllStringTags());

        fillEmptyFilter();
    }

    private static void addWordToElementeList(AddElemente addElemente) throws IOException {
        addElemente.addingElementFrage("Art", ManageElement.getAllStringArten());
        addElemente.addingElementFrage("Stimmung", ManageElement.getAllStringStimmungen());
        addElemente.addingElementFrage("Objekt", ManageElement.getAllStringObjekte(), ManageElement.getAllStringTags());
    }

    private static void deleteWordFromElementeList(DeleteElemente deleteElemente) throws IOException {
        deleteElemente.deletingElementFrage("Art", ManageElement.getAllStringArten());
        deleteElemente.deletingElementFrage("Stimmung", ManageElement.getAllStringStimmungen());
        deleteElemente.deletingElementFrage("Objekt", ManageElement.getAllStringObjekte());
    }

    private static void updateWordInElementeList(UpdateElemente updateElemente) throws IOException {
        updateElemente.updatingElementFrage("Art", ManageElement.getAllStringArten());
        updateElemente.updatingElementFrage("Stimmung", ManageElement.getAllStringStimmungen());
        updateElemente.updatingElementFrage("Objekt", ManageElement.getAllStringObjekte(), ManageElement.getAllStringTags());
    }

    private static void filterObjekteIfTag() {
        if (!filterEmpty(tagFilter)) {
            filterObjekte();
        }
    }

    private static void filterObjekte() {
        //nur Objekte mit Tags
    }

    private static String getIdea() {
        filterObjekteIfTag();
        return randomObtions();
    }

    private static String randomObtions() {
        String idea;
        idea = randomFilterObtion(artFilter);
        idea = idea.concat(" " + randomFilterObtion(stimmungFilter));
        idea = idea.concat(" " + randomFilterObtion(objektFilter));

        return idea;
    }

    private static String randomFilterObtion(String[] filter) {
        return filter[(int) (Math.random() * filter.length)];
    }

    private static void fillEmptyFilter() {
        if (filterEmpty(artFilter)) {
            artFilter = entittyListToStringArray(ManageElement.getAllArten());
        }
        if (filterEmpty(stimmungFilter)) {
            stimmungFilter = entittyListToStringArray(ManageElement.getAllStimmungen());
        }
        if (filterEmpty(objektFilter)) {
            objektFilter = entittyListToStringArray(ManageElement.getAllObjekte());
        }
    }

    private static boolean filterEmpty(String[] filter) {
        return filter.length == 0;
    }

    private static String[] entittyListToStringArray(List<Category> entityList) {
        String[] stringArray = new String[entityList.size()];
        for (int entityListSizeCounter = 0; entityListSizeCounter < entityList.size(); entityListSizeCounter++) {
            stringArray[entityListSizeCounter] = entityList.get(entityListSizeCounter).toString();
        }
        return stringArray;
    }

}
