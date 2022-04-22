package Controller.SearchElements;

import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

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
    public Idea(ManageElement manageElement) {
        this.manageElement = manageElement;
        SearchElements searchElements = new SearchElements(manageElement);
        this.searchIdea(searchElements);
    }

    public String toString() {
        if (this.objekt != null){
            return this.art.getDescription() + " " + this.stimmung.getDescription() + " " + this.objekt.getDescription();
        }
        return "";
    }

    void searchIdea(SearchElements searchElements) {
        getAllSearchElements(searchElements);
        filterIdea();
    }

    void getAllSearchElements(SearchElements searchElements) {
        artFilter = searchElements.getSearchElements(CategoryStatus.ART, manageElement.getAllArten());
        stimmungFilter = searchElements.getSearchElements(CategoryStatus.STIMMUNG, manageElement.getAllStimmungen());
        objektFilter = searchElements.getSearchElements(CategoryStatus.OBJEKT, manageElement.getAllObjekte());
        tagFilter = searchElements.getSearchTags();
    }

    //    Verhaltensmuster
    void filterIdea() {
        art = new FilterIdea(artFilter, manageElement.getAllArten()).random();
        stimmung = new FilterIdea(stimmungFilter, manageElement.getAllStimmungen()).random();
        objekt = new FilterObjektIdea(objektFilter, manageElement.getAllObjekte(), tagFilter).random();
    }

}
