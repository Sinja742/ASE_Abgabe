package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.Tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class HandlingElement {

    protected String handleElement(String kriterium, List<Category> allOptions, String action) throws IOException {
        GUI.showExistingElements(kriterium, ManageElement.toStringList(allOptions));
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie den Begriff für " + kriterium + " ein, den Sie " + action + " wollen: ");
        return tastatur.readLine();
    }

//    TODO: In UpdateElement action wort noch hinzufügen
    protected String getNewElement() throws IOException {
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie den neuen Begriff: ");
        return tastatur.readLine();
    }

}
