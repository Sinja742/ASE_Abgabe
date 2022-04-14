package jobs;

import Entity.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class TxtReader {
    String[] readTxt() {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("resources/Elemente.txt"));
            String text = bfr.readLine();
            bfr.close();
            return text.split("&&");
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
