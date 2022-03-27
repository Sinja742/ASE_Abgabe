package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class HandlingElement {
    
    public HandlingElement(GUI gui) {
        this.gui = gui;
    }

    static GUI gui;

    protected String handleElement(CategoryStatus categoryStatus, List<Category> allElements, String action) throws IOException {
        GUI.showExistingElements(categoryStatus.getStatus(), ManageElement.toStringList(allElements));
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie den Begriff für " + categoryStatus + " ein, den Sie " + action + " wollen: ");
        return tastatur.readLine();
    }
    
    protected String getNewElement() throws IOException {
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie den neuen Begriff: ");
        return tastatur.readLine();
    }

}
