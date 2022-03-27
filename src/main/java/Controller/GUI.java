package Controller;

import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUI {

//    TODO: searchElement / filterElement in eine neue Klasse packen

    public void showIdea(String idea) {
        System.out.println("Sie können hierzu kreativ werden: " + idea);
    }

    public Category[] getSearchOpportiunities(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        try {
            String question = "Wollen Sie nach " + categoryStatus.getStatusPlural() + " suchen?";
            if (this.trueBooleanQuestion(question)) {
                return this.getFilters(categoryStatus, allElements);
            } else {
                return new Category[0];
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Tag[] getSearchTags(List<Tag> allTags) throws IOException {
        try {
            String question = "Wollen Sie nach Tags suchen?";
            if (this.trueBooleanQuestion(question)) {
                return this.getTags(allTags);
            } else {
                return new Tag[0];
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean trueBooleanQuestion(String question) throws IOException {
        try {
            String JA = "j";
            String NEIN = "n";
            BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));

            System.out.print(question + " (" + JA + "/" + NEIN + "): ");
            return tastatur.readLine().equals(JA);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Category[] getFilters(CategoryStatus categoryStatus, List<Category> allElements) throws IOException {
        try {
            String[] filtersString = getStringArrayOfElements(categoryStatus, allElements, "Geben Sie die gewünschten " + categoryStatus.getStatusPlural() + " ein: ");
            Category[] filters = new Category[filtersString.length];
            for (int countFilter = 0; countFilter < filtersString.length; countFilter++) {
                filters[countFilter] = new Category(filtersString[countFilter]);
            }
            return filters;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[] getStringArrayOfElements(CategoryStatus categoryStatus, List<Category> allElements, String text) throws IOException {
        try {
            showExistingElements(categoryStatus.getStatus(), ManageElement.toStringList(allElements));
            System.out.println(text);

            BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
            return tastatur.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Tag[] getTags(List<Tag> allTags) throws IOException {
        try {
            String[] tagsString = getTagsString(allTags);
            Tag[] tags = new Tag[tagsString.length];
            for (int countTags = 0; countTags < tagsString.length; countTags++) {
                tags[countTags] = Tag.getTag(tagsString[countTags]);
            }
            return tags;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String[] getTagsString(List<Tag> allTags) throws IOException {
        try {
            showExistingElements("Tag", Tag.tagsToStringList(allTags));
            System.out.println("Geben Sie die gewünschten Tags ein: ");

            BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
            return tastatur.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void showExistingElements(String categoryStatus, List<String> allElements) {
        System.out.println("Diese Elemente des Typs " + categoryStatus + " existieren:");
        for (String option : allElements) {
            System.out.print(option + " ");
        }
        System.out.println();
    }

    public String getNewElement() throws IOException {
        try {
            BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Geben Sie den neuen Begriff: ");
            return tastatur.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
