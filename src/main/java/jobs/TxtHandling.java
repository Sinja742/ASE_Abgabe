package jobs;

import Entity.CategoryStatus;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TxtHandling {

    public static void addNewElement(String element, CategoryStatus status){
        String[] allTxtElements = TxtReader.readTxt();
        assert allTxtElements != null;
        if (status.equals(CategoryStatus.ART)){
            allTxtElements[0] = allTxtElements[0] + ","+ element;
        }else if (status.equals(CategoryStatus.STIMMUNG)){
            allTxtElements[1] = allTxtElements[1] + ","+ element;
        }else if (status.equals(CategoryStatus.OBJEKT)){
            allTxtElements[2] = allTxtElements[2] + ";"+ element;
        }
        updateTxtDocument(allTxtElements);
    }

    private static void updateTxtDocument(String[] allElements){
        try {
            File file = new File("resources/Elemente.txt");
            file.delete();
            file.createNewFile();
            PrintWriter out = new PrintWriter("resources/Elemente.txt");
            String text = allElements[0] + "&&" + allElements[1] + "&&" + allElements[2];
            out.println(text);
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteElement(String element, CategoryStatus status) {
        String[] allTextElements = TxtReader.readTxt();
        assert allTextElements != null;
        if (status.equals(CategoryStatus.ART)){
            allTextElements[0] = searchElementToDelete(element, allTextElements[0].split(","));
        }else if (status.equals(CategoryStatus.STIMMUNG)){
            allTextElements[1] = searchElementToDelete(element, allTextElements[1].split(","));
        }else if (status.equals(CategoryStatus.OBJEKT)){
            allTextElements[2] = searchObjektToDelete(element, allTextElements[2].split(";"));
        }
        updateTxtDocument(allTextElements);
    }

    private static String searchElementToDelete(String element, String[] allTextElements){
       List<String> returnArrayList = Stream.of(allTextElements).collect(Collectors.toList());
        for (String s : allTextElements){
            if (element.equals(s)){
                returnArrayList.remove(s);
            }
        }
        return String.join(",", returnArrayList);
    }

    private static String searchObjektToDelete(String element, String[] allTextElements){
        String[] objektArray;
        List<String> returnArrayList;
        List<String> returnObjektList = new ArrayList<>();
        for (String s : allTextElements) {
            objektArray = s.split(",");
            returnArrayList = Stream.of(objektArray).collect(Collectors.toList());
            if (element.equals(returnArrayList.get(0))) {
                returnArrayList.clear();
            } else {
                returnObjektList.add(String.join(",", returnArrayList));
            }
        }

        return String.join(";", returnObjektList);
    }
}
