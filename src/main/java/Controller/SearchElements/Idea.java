package Controller.SearchElements;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

import java.io.IOException;

public class Idea implements IdeaInterface {

    private Category art;
    private Category stimmung;
    private Category objekt;

    private Category[] artFilter;
    private Category[] stimmungFilter;
    private Category[] objektFilter;
    private Tag[] tagFilter;

//    Strukturmuster (Idee = Category+Category+Category)
    public Idea(GUI gui) throws IOException {
        SearchElements searchElements = new SearchElements(gui);
        this.searchIdea(searchElements);
    }

    public String toString() {
        return this.art.getDescription() + " " + this.stimmung.getDescription() + " " + this.objekt.getDescription();
    }

    private void searchIdea(SearchElements searchElements) throws IOException {
        getAllSearchElements(searchElements);
        filterIdea();
    }

    private void getAllSearchElements(SearchElements searchElements) throws IOException {
        artFilter = searchElements.getSearchElements(CategoryStatus.ART, ManageElement.getAllArten());
        stimmungFilter = searchElements.getSearchElements(CategoryStatus.STIMMUNG, ManageElement.getAllStimmungen());
        objektFilter = searchElements.getSearchElements(CategoryStatus.OBJEKT, ManageElement.getAllObjekte());
        tagFilter = searchElements.getSearchTags(Tag.getAllTags());
    }

//    Verhaltensmuster
    private void filterIdea() {
        art = new FilterIdea(artFilter, ManageElement.getAllArten()).random();
        stimmung = new FilterIdea(stimmungFilter, ManageElement.getAllStimmungen()).random();
        objekt = new FilterObjektIdea(objektFilter, ManageElement.getAllObjekte(), tagFilter).random();
    }

}
