package Jobs;

import Entity.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtHandling implements TxtHandlingInterface {

    File file = new File("Elemente.txt");

    public String[] readTxt() {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("Elemente.txt"));
            String text = bfr.readLine();
            return getCorrectArray(text.split("&&"));
        } catch (Exception e) {
            System.out.println("ERROR: Beim lesen der Elemente.txt Datei ist etwas schief gelaufen.");
            e.printStackTrace();
            return null;
        }
    }

    String[] getCorrectArray(String[] text) {
        if (text.length == 3) {
            return text;
        }
        String[] correctArray = new String[3];
        System.arraycopy(text, 0, correctArray, 0, text.length);
        correctArray[2] = "";
        return correctArray;
    }

    public void rewriteTxt(List<Category> arten, List<Category> stimmungen, List<Category> objekte) {
        deleteFile();
        writeFile(joinLists(arten, stimmungen, objekte));
    }

    private void deleteFile() {
        file.delete();
    }

    private void writeFile(String allElements) {
        try {
            file.createNewFile();
            PrintWriter out = new PrintWriter(file.getName());
            out.println(allElements);
            out.close();
        } catch (IOException e) {
            System.out.println("ERROR: Beim schreiben in die Elemente.txt Datei ist etwas schief gelaufen.");
            e.printStackTrace();
        }

    }

    String toTxtString(List<Category> elementlist) {
        List<String> returnStringList = new ArrayList<>();
        for (Category element : elementlist) {
            returnStringList.add(element.toString());
        }
        return String.join(",", returnStringList);
    }

    String joinLists(List<Category> arten, List<Category> stimmungen, List<Category> objekte) {
        String elementsList = toTxtString(arten);
        elementsList = elementsList.concat("&&");
        elementsList = elementsList.concat(toTxtString(stimmungen));
        elementsList = elementsList.concat("&&");
        elementsList = elementsList.concat(toTxtString(objekte));
        return elementsList;
    }
}
