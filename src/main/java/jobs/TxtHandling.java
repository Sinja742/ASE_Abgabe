package jobs;

import Entity.EntityStatus;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TxtHandling {

    public static void addElement(String element, EntityStatus status) throws IOException {
        String[] elementArray = TxtReader.readYml();
        assert elementArray != null;
        if (status.equals(EntityStatus.ART)){
            elementArray[0] = elementArray[0] + ","+ element;
        }else if (status.equals(EntityStatus.STIMMUNG)){
            elementArray[1] = elementArray[1] + ","+ element;
        }else if (status.equals(EntityStatus.OBJEKT)){
            elementArray[2] = elementArray[2] + ";"+ element;
        }
        createNewTxtDocument(elementArray);
    }

    private static void createNewTxtDocument(String[] elementArray) throws IOException {
        File file = new File("resources/Elemente.txt");
        file.delete();
        file.createNewFile();
        PrintWriter out = new PrintWriter("resources/Elemente.txt");
        String text = elementArray[0] + "&&" + elementArray[1] + "&&" + elementArray[2];
        out.println(text);
        out.close();
    }

    public static void deleteElement(String element, EntityStatus status) throws IOException {
        String[] elementArray = TxtReader.readYml();
        assert elementArray != null;
        if (status.equals(EntityStatus.ART)){
            elementArray[0] = searchElementToDelete(element, elementArray[0].split(","));
        }else if (status.equals(EntityStatus.STIMMUNG)){
            elementArray[1] = searchElementToDelete(element, elementArray[1].split(","));
        }else if (status.equals(EntityStatus.OBJEKT)){
            elementArray[2] = searchObjektToDelete(element, elementArray[2].split(";"));
        }
        createNewTxtDocument(elementArray);
    }

    private static String searchElementToDelete(String element, String[] elementArray){
       List<String> returnArrayList = Stream.of(elementArray).collect(Collectors.toList());
        for (String s : elementArray){
            if (element.equals(s)){
                returnArrayList.remove(s);
            }
        }
        return String.join(",", returnArrayList);
    }

    private static String searchObjektToDelete(String element, String[] elementArray){
        String[] objektArray;
        List<String> returnArrayList;
        List<String> returnObjektList = new ArrayList<>();
        for (String s : elementArray) {
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
