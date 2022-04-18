package jobs;

import Entity.Category;
import Entity.SimpleCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TxtHandlingTest {

    BufferedReader bfr = mock(BufferedReader.class);
    TxtHandling handlerTxt = new TxtHandling(bfr);

    TxtHandlingTest() {
    }

    @Test
    void readTxt() throws IOException {
//        Given
        String[] testArray = {"art1,art2,art3","stimmung1,stimmung2,stimmun3","objekt1;1;2,objekt2;3;4,objekt3;3;1"};
        when(bfr.readLine()).thenReturn("art1,art2,art3&&stimmung1,stimmung2,stimmun3&&objekt1;1;2,objekt2;3;4,objekt3;3;1");
//        When
        String[] returnArray = handlerTxt.readTxt();
//        Then
        assertEquals(testArray.length,returnArray.length);
        assertEquals(Arrays.toString(testArray), Arrays.toString(returnArray));
    }

    @Test
    void toTxtString(){
        List<Category> testArten = new ArrayList<>();
        testArten.add(new SimpleCategory("art1"));
        testArten.add(new SimpleCategory("art2"));
        testArten.add(new SimpleCategory("art3"));

        String returnString = handlerTxt.toTxtString(testArten);

        assertEquals("art1,art2,art3", returnString);
    }

    @Test
    void joinList(){
        List<Category> testArten = new ArrayList<>();
        testArten.add(new SimpleCategory("art1"));
        testArten.add(new SimpleCategory("art2"));
        testArten.add(new SimpleCategory("art3"));
        List<Category> testStimmungen = new ArrayList<>();
        testStimmungen.add(new SimpleCategory("stimmung1"));
        testStimmungen.add(new SimpleCategory("stimmung2"));
        testStimmungen.add(new SimpleCategory("stimmung3"));
        List<Category> testObjekt = new ArrayList<>();
        testObjekt.add(new SimpleCategory("objekt1;1"));
        testObjekt.add(new SimpleCategory("objekt2;2"));
        testObjekt.add(new SimpleCategory("objekt3;3"));

        String returnString = handlerTxt.joinLists(testArten,testStimmungen,testObjekt);

        assertEquals("art1,art2,art3&&stimmung1,stimmung2,stimmung3&&objekt1;1,objekt2;2,objekt3;3",returnString);
    }
}