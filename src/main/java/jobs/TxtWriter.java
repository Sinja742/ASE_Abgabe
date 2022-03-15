package jobs;

import Entity.EntityStatus;

import java.io.*;

public class TxtWriter {

    public static void addElement(String element, EntityStatus status) throws IOException {
       String[] elementArray = TxtReader.readYml();
       assert elementArray != null;
       if (status.equals(EntityStatus.ART)){
           elementArray[0] = elementArray[0] + ","+ element;
       }else if (status.equals(EntityStatus.STIMMUNG)){
           elementArray[1] = elementArray[1] + ","+ element;
       }else if (status.equals(EntityStatus.OBJEKT)){
           elementArray[2] = elementArray[2] + ","+ element;
       }
       createNewTxtDocument(elementArray);
    }

    private static void createNewTxtDocument(String[] elementArray) throws IOException {
        PrintWriter out = new PrintWriter("Elemente.txt");
        String text = elementArray[0] + "&&" + elementArray[1] + "&&" + elementArray[2];
        out.println(text);
        out.close();
    }

}
