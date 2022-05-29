package Controller;

import Entity.Category;
import Entity.CategoryStatus;
import Entity.Tag;
import Error.FalseInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GUI implements GUIInterface {

    private final CheckInput checkInput;

    public GUI(CheckInput checkInput) {
        this.checkInput = checkInput;
    }

    public void showIdea(String idea) {
        System.out.println("Sie können hierzu kreativ werden: " + idea);
    }

    public boolean trueBooleanQuestion(String question) {
        try {
            String JA = "j";
            String NEIN = "n";
            BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));

            System.out.print(question + " (" + JA + "/" + NEIN + "): ");
            String eingabe = tastatur.readLine();
            if (eingabe.equals(JA)) {
                return true;
            } else if (eingabe.equals(NEIN)) {
                return false;
            } else {
                throw new FalseInputException();
            }
        } catch (FalseInputException ex) {
            System.out.println(ex.getMessage());
            return trueBooleanQuestion(question);
        } catch (IOException e) {
            throwProcessingError(e);
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
            throwProcessingError(e);
            return getStringArrayOfElements(categoryStatus, allElements, text);
        }
    }

    public Tag[] getTags() {
        String[] tagsString = getTagsString();
        Tag[] tags = new Tag[tagsString.length];
        for (int countTags = 0; countTags < tagsString.length; countTags++) {
            tags[countTags] = Tag.getTag(tagsString[countTags]);
        }
        return tags;
    }

    public String[] getTagsString() {
        try {
            showExistingElements("Tag", Tag.tagsToStringList(Tag.getAllTags()));
            System.out.println("Geben Sie die gewünschten Tags ein: ");

            BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
            String[] eingabe = tastatur.readLine().split(" ");
            if (!this.checkInput.checkTagsExist(eingabe)) {
                return getTagsString();
            }
            return eingabe;
        } catch (IOException e) {
            throwProcessingError(e);
            return getTagsString();
        }
    }

    public void showExistingElements(String categoryStatus, List<String> allElements) {
        System.out.println("Diese Elemente des Typs " + categoryStatus + " existieren:");
        for (String option : allElements) {
            System.out.print(option + " ");
        }
        System.out.println();
    }

    public String getNewElement(CategoryStatus categoryStatus) {
        try {
            BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Geben Sie den neuen Begriff: ");
            return tastatur.readLine();
        } catch (IOException e) {
            throwProcessingError(e);
            return getNewElement(categoryStatus);
        }
    }

    private void throwProcessingError(IOException e) {
        System.out.println("ERROR: Bei der Verarbeitung ihrer Eingabe ist etwas schief gelaufen. Bitte versuchen Sie es erneut.");
        e.printStackTrace();
    }
}
