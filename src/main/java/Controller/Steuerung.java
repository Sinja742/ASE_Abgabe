package Controller;

import Controller.AddElemente;
import jobs.TxtReader;
import Entity.Entity;
import Entity.EntityStatus;
import Entity.Tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Steuerung {

    public static void main(String[] args) throws IOException {
        gui = new GUI();
        elementeController = new ElementeController();
        AddElemente addElemente = new AddElemente(gui);

        while(true) {
            userIneraction(addElemente);
        }
    }

    private static GUI gui;
    private static ElementeController elementeController;

    private static String[] artFilter;
    private static String[] stimmungFilter;
    private static String[] objektFilter;
    private static String[] tagFilter;

    private static void userIneraction(AddElemente addElemente) throws IOException {
        if(gui.trueBooleanQuestion("Wollen Sie nach einer kreativen Idee suchen?")) {
            searchIdea();
        }
        if(gui.trueBooleanQuestion("Wollen Sie neue Elemente hinzufügen?")) {
            addWordToElementeList(addElemente);
        }
        if(gui.trueBooleanQuestion("Wollen Sie Elemente bearbeiten?")) {
        }
        if(gui.trueBooleanQuestion("Wollen Sie Elemente löschen?")) {
        }
    }

    private static void searchIdea() throws IOException {
        getAllSearchOpportiunities();
        gui.showIdea(getIdea());
    }

    private static void getAllSearchOpportiunities() throws IOException {
        artFilter = gui.getSearchOpportiunities("Arten", elementeController.getAllStringArten());
        stimmungFilter = gui.getSearchOpportiunities("Stimmungen", elementeController.getAllStringStimmungen());
        objektFilter = gui.getSearchOpportiunities("Objekte", elementeController.getAllStringObjekte());
        tagFilter = gui.getSearchOpportiunities("Tags", elementeController.getAllStringTags());

        fillEmptyFilter();
    }

    private static void addWordToElementeList(AddElemente addElemente) throws IOException {
        addElemente.addingElement("Art" , elementeController.getAllStringArten());
        addElemente.addingElement("Stimmung" , elementeController.getAllStringStimmungen());
        addElemente.addingElement("Objekt" , elementeController.getAllStringObjekte(), elementeController.getAllStringTags());
    }

    private static void filterObjekteIfTag() {
        if(!filterEmpty(tagFilter)) {
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
        return filter[(int)(Math.random()*filter.length)];
    }

    private static void fillEmptyFilter() {
        if(filterEmpty(artFilter)) {
            artFilter = entittyListToStringArray(elementeController.getAllArten());
        }
        if(filterEmpty(stimmungFilter)) {
            stimmungFilter = entittyListToStringArray(elementeController.getAllStimmungen());
        }
        if(filterEmpty(objektFilter)) {
            objektFilter = entittyListToStringArray(elementeController.getAllObjekte());
        }
    }

    private static boolean filterEmpty(String[] filter) {
        return filter.length == 0;
    }

    private static String[] entittyListToStringArray(List<Entity> entityList) {
        String[] stringArray = new String[entityList.size()];
        for(int entityListSizeCounter = 0; entityListSizeCounter < entityList.size(); entityListSizeCounter++) {
            stringArray[entityListSizeCounter] = entityList.get(entityListSizeCounter).toString();
        }
        return stringArray;
    }

}
