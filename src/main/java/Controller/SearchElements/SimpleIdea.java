package Controller.SearchElements;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

import java.io.IOException;

public class SimpleIdea implements Idea {

    private static Category art;
    private static Category stimmung;
    private static Category objekt;

    private static Category[] artFilter;
    private static Category[] stimmungFilter;
    private static Category[] objektFilter;
    private static Tag[] tagFilter;

    public SimpleIdea(GUI gui) throws IOException {
        SearchElements searchElements = new SearchElements(gui);
        this.searchIdea(searchElements);
    }

    @Override
    public String toString() {
        return this.art.getDescription() + " " + this.stimmung.getDescription() + " " + this.objekt.getDescription();
    }

    private void searchIdea(SearchElements searchElements) throws IOException {
        getAllSearchElements(searchElements);
        filterIdea();
    }

    private static void getAllSearchElements(SearchElements searchElements) throws IOException {
        artFilter = searchElements.getSearchElements(CategoryStatus.ART, ManageElement.getAllArten());
        stimmungFilter = searchElements.getSearchElements(CategoryStatus.STIMMUNG, ManageElement.getAllStimmungen());
        objektFilter = searchElements.getSearchElements(CategoryStatus.OBJEKT, ManageElement.getAllObjekte());
        tagFilter = searchElements.getSearchTags(Tag.getAllTags());
    }

    private void filterIdea() {
        art = new FilterIdea(artFilter, ManageElement.getAllArten()).random();
        stimmung = new FilterIdea(stimmungFilter, ManageElement.getAllStimmungen()).random();
        objekt = new FilterObjektIdea(objektFilter, ManageElement.getAllObjekte(), tagFilter).random();
    }

}
