package Controller;

import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;

import Error.FalseInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GUI {

//    TODO: searchElement / filterElement in eine neue Klasse packen

    public void showIdea(String idea) {
        System.out.println("Sie können hierzu kreativ werden: " + idea);
    }

    // Falsche eingabe abgefangen und neue exception wird geworfen --> Rekursiver aufruf damit eine korrekte eingabe stattfinden kann
    public boolean trueBooleanQuestion(String question) {
        try {
            String JA = "j";
            String NEIN = "n";
            BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));

            System.out.print(question + " (" + JA + "/" + NEIN + "): ");
            if (tastatur.readLine().equals(JA)){
                return true;
            }else if (tastatur.readLine().equals(NEIN)){
                return false;
            }else {
                throw new FalseInputException();
            }
        } catch (FalseInputException ex) {
            System.out.println(ex.getMessage());
            return trueBooleanQuestion(question);
        } catch (IOException e){
            System.out.println("Bei der Verarbeitung ihrer Eingabe ist etwas schief gelaufen. Bitte versuchen Sie es erneut.");
            e.printStackTrace();
            return trueBooleanQuestion(question);
        }
    }

    public String[] getStringArrayOfElements(CategoryStatus categoryStatus, List<Category> allElements, String text) {
        try {
            showExistingElements(categoryStatus.getStatus(), ManageElement.toStringList(allElements));
            System.out.println(text);

            BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
            return tastatur.readLine().split(" ");
        } catch (IOException e) {
            System.out.println("Bei der Verarbeitung ihrer Eingabe ist etwas schief gelaufen. Bitte versuchen Sie es erneut.");
            e.printStackTrace();
            return getStringArrayOfElements(categoryStatus, allElements, text);
        }
    }
//      TODO: können gleiche tags mehrmals angelegt sein ? --> objekte bearbeiten und neu anlegen
    public static Tag[] getTags(List<Tag> allTags) {
        String[] tagsString = getTagsString(allTags);
        Tag[] tags = new Tag[tagsString.length];
        for (int countTags = 0; countTags < tagsString.length; countTags++) {
//            Abfrage ob tag existiert
//            Was machen wir mit tags die falsch geschrieben sind ?
            tags[countTags] = Tag.getTag(tagsString[countTags]);
        }
        return tags;
    }

//
    private static String[] getTagsString(List<Tag> allTags) {
        try {
            showExistingElements("Tag", Tag.tagsToStringList(allTags));
            System.out.println("Geben Sie die gewünschten Tags ein: ");

            BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
            return tastatur.readLine().split(" ");
        } catch (IOException e) {
            System.out.println("Bei der Verarbeitung ihrer Eingabe ist etwas schief gelaufen. Bitte versuchen Sie es erneut.");
            e.printStackTrace();
            return getTagsString(allTags);
        }
    }

    public static void showExistingElements(String categoryStatus, List<String> allElements) {
        System.out.println("Diese Elemente des Typs " + categoryStatus + " existieren:");
        for (String option : allElements) {
            System.out.print(option + " ");
        }
        System.out.println();
    }

    public String getNewElement() {
        try {
            BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Geben Sie den neuen Begriff: ");
            return tastatur.readLine();
        } catch (IOException e) {
            System.out.println("Bei der Verarbeitung ihrer Eingabe ist etwas schief gelaufen. Bitte versuchen Sie es erneut.");
            e.printStackTrace();
            return getNewElement();
        }
    }
}
