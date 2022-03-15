import jobs.TxtReader;
import Entity.Entity;
import Entity.EntityStatus;
import Entity.Tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Steuerung {

    public static void main(String[] args) throws IOException {
        GUI gui = new GUI();
        getAllTags();
        getOpportunities();

        while (true) {
            userIneraction(gui);
        }
    }

    private static List<Entity> artList;
    private static List<Entity> stimmungList;
    private static List<Entity> objektList;
    private static List<String> tagList = new ArrayList<>();

    private static String[] artFilter;
    private static String[] stimmungFilter;
    private static String[] objektFilter;
    private static String[] tagFilter;

    private static void getAllTags() {
        for (Tags tag : Tags.values()) {
            tagList.add(tag.toString());
        }
    }

    private static void userIneraction(GUI gui) throws IOException {
        getAllSearchOpportiunities(gui);
        gui.showIdea(getIdea());
        addWordToElementeList(gui);
    }

    private static void getAllSearchOpportiunities(GUI gui) throws IOException {
        artFilter = gui.getSearchOpportiunities("Arten", artList);
        stimmungFilter = gui.getSearchOpportiunities("Stimmungen", stimmungList);
        objektFilter = gui.getSearchOpportiunities("Objekte", objektList);
        tagFilter = gui.getSearchTags(tagList);

        fillEmptyFilter();
    }

    private static void addWordToElementeList(GUI gui) throws IOException {
        gui.getAddingElement();
    }

    private static void getOpportunities() {
        readEntitys();
    }

    private static void readEntitys() {
        artList = TxtReader.readEntity(EntityStatus.ART);
        stimmungList = TxtReader.readEntity(EntityStatus.STIMMUNG);
        objektList = TxtReader.readEntity(EntityStatus.OBJEKT);
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
            artFilter = entittyListToStringArray(artList);
        }
        if (filterEmpty(stimmungFilter)) {
            stimmungFilter = entittyListToStringArray(stimmungList);
        }
        if (filterEmpty(objektFilter)) {
            objektFilter = entittyListToStringArray(objektList);
        }
    }

    private static boolean filterEmpty(String[] filter) {
        return filter.length == 0;
    }

    private static String[] entittyListToStringArray(List<Entity> entityList) {
        String[] stringArray = new String[entityList.size()];
        for (int entityListSizeCounter = 0; entityListSizeCounter < entityList.size(); entityListSizeCounter++) {
            stringArray[entityListSizeCounter] = entityList.get(entityListSizeCounter).toString();
        }
        return stringArray;
    }

}
