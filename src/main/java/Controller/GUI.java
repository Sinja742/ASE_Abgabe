package Controller;

import Entity.Category;
import Entity.Tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUI {

    public void showIdea(String idea) {
        System.out.println("Sie können hierzu kreativ werden: " + idea);
    }

    public Category[] getSearchOpportiunities(String kriterium, List<Category> allOptions) throws IOException {
        String question = "Wollen Sie nach " + kriterium + " suchen?";
        if(this.trueBooleanQuestion(question)) {
            return this.getFilters(kriterium, allOptions);
        } else {
            return new Category[0];
        }
    }

    public Tag[] getSearchTags(List<Tag> allTags) throws IOException {
        String question = "Wollen Sie nach Tags suchen?";
        if(this.trueBooleanQuestion(question)) {
            return this.getTags(allTags);
        } else {
            return new Tag[0];
        }
    }

    public boolean trueBooleanQuestion(String question) throws IOException {
        String JA = "j";
        String NEIN = "n";
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(question + " (" + JA + "/" + NEIN + "): ");
        return tastatur.readLine().equals(JA);
    }

    private Category[] getFilters(String kriterium, List<Category> allOptions) throws IOException {
        String[] filtersString = getFiltersString(kriterium, allOptions);
        Category[] filters = new Category[filtersString.length];
        for(int countFilter = 0; countFilter < filtersString.length; countFilter++) {
            filters[countFilter] = new Category(filtersString[countFilter]);
        }
        return filters;
    }

    private String[] getFiltersString(String kriterium, List<Category> allOptions) throws IOException {
        showExistingElements(kriterium, ManageElement.toStringList(allOptions));
        System.out.println("Geben Sie die gewünschten " + kriterium + " ein: ");

        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        return tastatur.readLine().split(" ");
    }

    public static Tag[] getTags(List<Tag> allTags) throws IOException {
        String[] tagsString = getTagsString(allTags);
        Tag[] tags = new Tag[tagsString.length];
        for(int countTags = 0; countTags < tagsString.length; countTags++) {
            tags[countTags] = Tag.getTag(tagsString[countTags]);
        }
        return tags;
    }

    private static String[] getTagsString(List<Tag> allTags) throws IOException {
        showExistingElements("Tag", Tag.tagsToStringList(allTags));
        System.out.println("Geben Sie die gewünschten Tags ein: ");

        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        return tastatur.readLine().split(" ");
    }

    public static void showExistingElements(String kriterium, List<String> allElements) {
        System.out.println("Diese Elemente des Typs " + kriterium + " existieren:");
        for (String option : allElements) {
            System.out.print(option + " ");
        }
        System.out.println();
    }
}
