package Controller;

import Entity.Entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GUI {
    final String JA = "j";
    final String NEIN = "n";

    public void showIdea(String idea) {
        System.out.println("Sie können hierzu kreativ werden: " + idea);
    }

    public String[] getSearchOpportiunities(String kriterium, List<Entity> allOptions) throws IOException {
        String question = "Wollen Sie nach " + kriterium + " suchen?";
        if(this.trueBooleanQuestion(question)) {
            return this.getFilters(kriterium, allOptions);
        } else {
            return new String[0];
        }
    }

    public String[] getSearchTags(List<String> allTags) throws IOException {
        String question = "Wollen Sie nach Tags suchen?";
        if(this.trueBooleanQuestion(question)) {
            return this.getTags(allTags);
        } else {
            return new String[0];
        }
    }

    public boolean trueBooleanQuestion(String question) throws IOException {
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(question + " (" + this.JA + "/" + this.NEIN + "): ");
        return tastatur.readLine().equals(this.JA);
    }

    private String[] getFilters(String kriterium, List<Entity> allOptions) throws IOException {
        this.showOpportunities(kriterium, getAllOptionsString(allOptions));
        System.out.println("Geben Sie die gewünschten " + kriterium + " ein: ");

        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        return tastatur.readLine().split(" ");
    }

    private List<String> getAllOptionsString(List<Entity> allOptions) {
        List<String> allOptionsString = new ArrayList<>();
        for(Entity option : allOptions) {
            allOptionsString.add(option.toString());
        }

        return allOptionsString;
    }

    private String[] getTags(List<String> allTags) throws IOException {
        this.showOpportunities("Tags", allTags);
        System.out.println("Geben Sie die gewünschten Tags ein: ");

        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        return tastatur.readLine().split(" ");
    }

    private void showOpportunities(String kriterium, List<String> allOptions) {
        System.out.println("Diese " + kriterium + " können gesetzt werden:");
        for(String option : allOptions) {
            System.out.print(option + " ");
        }
        System.out.println();
    }
}