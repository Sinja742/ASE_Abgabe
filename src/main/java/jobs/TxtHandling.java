package jobs;

import Entity.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtHandling {

    File file = new File("Elemente.txt");

    String[] readTxt() {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("Elemente.txt"));
            String text = bfr.readLine();
            bfr.close();
            return text.split("&&");
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public void rewriteTxt(List<Category> arten, List<Category> stimmungen, List<Category> objekte) throws IOException {
        deleteFile();
        writeFile(joinLists(arten, stimmungen, objekte));
    }

    private void deleteFile() {
        file.delete();
    }

    private void writeFile(String allElements) throws IOException {
        file.createNewFile();
        PrintWriter out = new PrintWriter(file.getName());
        out.println(allElements);
        out.close();
    }

    private String toTxtString(List<Category> elementlist){
        List<String> returnStringList = new ArrayList<>();
        for (Category element : elementlist) {
            returnStringList.add(element.toString());
        }
        return String.join(",",returnStringList);
    }

    private String joinLists(List<Category> arten, List<Category> stimmungen, List<Category> objekte){
        String elementsList = toTxtString(arten);
        elementsList = elementsList.concat("&&");
        elementsList = elementsList.concat(toTxtString(stimmungen));
        elementsList = elementsList.concat("&&");
        elementsList = elementsList.concat(toTxtString(objekte));
        return elementsList;
    }
}
