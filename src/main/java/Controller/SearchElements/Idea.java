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

    private final ManageElement manageElement;

    //    Strukturmuster (Idee = Category+Category+Category)
    public Idea(GUI gui, ManageElement manageElement) throws IOException {
        this.manageElement = manageElement;
        SearchElements searchElements = new SearchElements(gui, manageElement);
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
        artFilter = searchElements.getSearchElements(CategoryStatus.ART, manageElement.getAllArten());
        stimmungFilter = searchElements.getSearchElements(CategoryStatus.STIMMUNG, manageElement.getAllStimmungen());
        objektFilter = searchElements.getSearchElements(CategoryStatus.OBJEKT, manageElement.getAllObjekte());
        tagFilter = searchElements.getSearchTags(Tag.getAllTags());
    }

    //    Verhaltensmuster
    private void filterIdea() {
        art = new FilterIdea(artFilter, manageElement.getAllArten()).random();
        stimmung = new FilterIdea(stimmungFilter, manageElement.getAllStimmungen()).random();
        objekt = new FilterObjektIdea(objektFilter, manageElement.getAllObjekte(), tagFilter).random();
    }

}
