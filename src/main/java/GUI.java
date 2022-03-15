import Entity.Entity;
import Entity.EntityStatus;
import jobs.TxtWriter;
import Entity.Tags;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class GUI {
    final String JA = "j";
    final String NEIN = "n";

    public void showIdea(String idea) {
        System.out.println("Sie können hierzu kreativ werden : " + idea);
    }

    public String[] getSearchOpportiunities(String kriterium, List<Entity> allOptions) throws IOException {
        if (this.wantSearch(kriterium)) {
            return this.getFilters(kriterium, allOptions);
        } else {
            return new String[0];
        }
    }

    public String[] getSearchTags(List<String> allTags) throws IOException {
        if (this.wantSearch("Tags")) {
            return this.getTags(allTags);
        } else {
            return new String[0];
        }
    }

    private boolean wantSearch(String kriterium) throws IOException {
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Wollen Sie nach " + kriterium + " suchen? (" + this.JA + "/" + this.NEIN + "): ");
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
        for (Entity option : allOptions) {
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
        for (String option : allOptions) {
            System.out.print(option + " ");
        }
        System.out.println();
    }

    public void getAddingElement() throws IOException {
        if (wantAdd()) {
            addArtElement();
            addStimmungElement();
            addObjektElement();
        }
    }

    private boolean wantAdd() throws IOException {
        System.out.println("Wollen Sie ein Element hinzufügen? (" + this.JA + "/" + this.NEIN + "): ");

        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        return tastatur.readLine().equals(this.JA);
    }

    private void addArtElement() throws IOException {
        System.out.println("Wollen Sie ein Element zum Typ Art hinzufügen? (" + this.JA + "/" + this.NEIN + "): ");
        String element;
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        if (tastatur.readLine().equals(this.JA)) {
            System.out.println("Geben Sie ein Wort für Art ein: ");
            element = tastatur.readLine();
            TxtWriter.addElement(element, EntityStatus.ART);
        }
    }

    private void addStimmungElement() throws IOException {
        System.out.println("Wollen Sie ein Element zum Typ Stimmung hinzufügen? (" + this.JA + "/" + this.NEIN + "): ");
        String element;
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        if (tastatur.readLine().equals(this.JA)) {
            System.out.println("Geben Sie ein Wort für Stimmung ein: ");
            element = tastatur.readLine();
            TxtWriter.addElement(element, EntityStatus.STIMMUNG);
        }
    }

    private void addObjektElement() throws IOException {
        System.out.println("Wollen Sie ein Element zum Typ Objekt hinzufügen? (" + this.JA + "/" + this.NEIN + "): ");
        String element;
        String[] tagsEntered;
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));

        if (tastatur.readLine().equals(this.JA)) {
            System.out.println("Geben Sie ein Wort für Objekt ein: ");
            element = tastatur.readLine();
            System.out.println("Wollen sie tags zu diesem Wort hinzufügen? (" + this.JA + "/" + this.NEIN + "): ");
            if (tastatur.readLine().equals(this.JA)) {
                System.out.println("Diese Tags stehen ihnen zur Auswahl: ");
                Tags[] tagsArray = Tags.values();
                StringBuilder tags = new StringBuilder();
                for (Tags value : tagsArray) {
                    tags.append(value).append(" ");
                }
                System.out.println(tags);
                tagsEntered = tastatur.readLine().split(" ");

                for (String s : tagsEntered) {
                    for (Tags tag : Tags.values()) {
                        if (tag.toString().equals(s)) {
                            element = element + "," + tag.getId();
                        }
                    }
                }
            }
            TxtWriter.addElement(element, EntityStatus.OBJEKT);
        }
    }
}
