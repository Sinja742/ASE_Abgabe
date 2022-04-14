package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;
import jobs.TxtHandling;

import java.io.IOException;
import java.util.List;

public abstract class HandlingElement {
    
    public HandlingElement(GUI gui, ManageElement manageElement) {
        this.gui = gui;
        this.manageElement = manageElement;
    }

    protected GUI gui;
    protected ManageElement manageElement;

    protected String handleElement(CategoryStatus categoryStatus, List<Category> allElements, String action) throws IOException {
        String text = "Geben Sie den Begriff für " + categoryStatus + " ein, den Sie " + action + " wollen: ";
        return gui.getStringArrayOfElements(categoryStatus, allElements, text)[0];
    }

}
