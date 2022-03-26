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

    public String[] getSearchOpportiunities(String kriterium, List<String> allOptions) throws IOException {
        String question = "Wollen Sie nach " + kriterium + " suchen?";
        if(this.trueBooleanQuestion(question)) {
            return this.getFilters(kriterium, allOptions);
        } else {
            return new String[0];
        }
    }

    public boolean trueBooleanQuestion(String question) throws IOException {
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(question + " (" + this.JA + "/" + this.NEIN + "): ");
        return tastatur.readLine().equals(this.JA);
    }

    private String[] getFilters(String kriterium, List<String> allOptions) throws IOException {
        this.showOpportunities(kriterium, allOptions);
        System.out.println("Geben Sie die gewünschten " + kriterium + " ein: ");

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
