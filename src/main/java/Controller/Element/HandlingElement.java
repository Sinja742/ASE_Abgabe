package Controller.Element;

import Controller.GUI;
import Entity.Category;
import Entity.CategoryStatus;

import java.io.IOException;
import java.util.List;

public class HandlingElement {
    
    public HandlingElement(GUI gui) {
        this.gui = gui;
    }

    static GUI gui;

    protected String handleElement(CategoryStatus categoryStatus, List<Category> allElements, String action) throws IOException {
        try {
            String text = "Geben Sie den Begriff für " + categoryStatus + " ein, den Sie " + action + " wollen: ";
            return gui.getStringArrayOfElements(categoryStatus, allElements, text)[0];
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
