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

    public boolean trueBooleanQuestion(String question) throws IOException {
        String JA = "j";
        String NEIN = "n";
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(question + " (" + JA + "/" + NEIN + "): ");
        return tastatur.readLine().equals(JA);
    }

    public String[] getStringArrayOfElements(CategoryStatus categoryStatus, List<Category> allElements, String text) throws IOException {
        showExistingElements(categoryStatus.getStatus(), ManageElement.toStringList(allElements));
        System.out.println(text);

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

    public static String[] getTagsString(List<Tag> allTags) throws IOException {
        showExistingElements("Tag", Tag.tagsToStringList(allTags));
        System.out.println("Geben Sie die gewünschten Tags ein: ");

        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        return tastatur.readLine().split(" ");
    }

    public static void showExistingElements(String categoryStatus, List<String> allElements) {
        System.out.println("Diese Elemente des Typs " + categoryStatus + " existieren:");
        for (String option : allElements) {
            System.out.print(option + " ");
        }
        System.out.println();
    }

    public String getNewElement() throws IOException {
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie den neuen Begriff: ");
        return tastatur.readLine();
    }
}
