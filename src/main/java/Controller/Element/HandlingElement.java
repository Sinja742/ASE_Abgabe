package Controller.Element;

import Controller.CheckInput;
import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;

import java.util.List;

public abstract class HandlingElement {

    public HandlingElement(ManageElement manageElement) {
        this.manageElement = manageElement;
        this.checkInput = new CheckInput(this.manageElement);
        this.gui = new GUI(this.checkInput);
    }

    //Testing
    public HandlingElement(GUI gui, ManageElement manageElement) {
        this.gui = gui;
        this.manageElement = manageElement;
        this.checkInput = new CheckInput(this.manageElement);
    }

    protected GUI gui;
    protected ManageElement manageElement;
    protected final CheckInput checkInput;

    protected String handleElement(CategoryStatus categoryStatus, List<Category> allElements, String action) {
        String text = "Geben Sie den Begriff für " + categoryStatus + " ein, den Sie " + action + " wollen: ";
        return gui.getStringArrayOfElements(categoryStatus, allElements, text)[0];
    }
}
