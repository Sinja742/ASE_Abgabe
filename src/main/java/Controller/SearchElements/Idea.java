package Controller.SearchElements;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Idea {

    private static Category[] artFilter;
    private static Category[] stimmungFilter;
    private static Category[] objektFilter;
    private static Tag[] tagFilter;

    private static GUI gui;
    private static SearchElements searchElements;

    public Idea(GUI gui) {
        this.gui = gui;
        this.searchElements = new SearchElements(this.gui);
    }

    public void searchIdea() throws IOException {
        getAllSearchElements();
        gui.showIdea(getIdea());
    }

    private static void getAllSearchElements(){
        artFilter = searchElements.getSearchElements(CategoryStatus.ART, ManageElement.getAllArten());
        stimmungFilter = searchElements.getSearchElements(CategoryStatus.STIMMUNG, ManageElement.getAllStimmungen());
        objektFilter = searchElements.getSearchElements(CategoryStatus.OBJEKT, ManageElement.getAllObjekte());
        tagFilter = searchElements.getSearchTags(Tag.getAllTags());

        fillEmptyFilter();
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

    private static boolean filterEmpty(Category[] filter) {
        return filter.length == 0;
    }

    private static boolean filterEmpty(Tag[] filter) {
        return filter.length == 0;
    }
}
