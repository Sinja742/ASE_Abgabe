package Jobs;

import Entity.Category;
import Entity.SimpleCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TxtHandlingTest {

    TxtHandling handlerTxt;

    @BeforeEach
    void setUp() {
        handlerTxt = new Jobs.TxtHandling();
    }

    @Test
    void getCorrectArrayCorrect() {
        //Given
        String[] text = {"Art1,Art2", "Strimmung1,Stimmung2", "Objekt1,Objekt2"};

        //When
        String[] correctTextArray = handlerTxt.getCorrectArray(text);

        //Then
        assertEquals(text.length, correctTextArray.length);
        assertEquals(text[0], correctTextArray[0]);
        assertEquals(text[1], correctTextArray[1]);
        assertEquals(text[2], correctTextArray[2]);
    }

    @Test
    void getCorrectArrayFalse() {
        //Given
        String[] text = {"Art1,Art2", "Strimmung1,Stimmung2"};

        //When
        String[] correctTextArray = handlerTxt.getCorrectArray(text);

        //Then
        assertEquals(3, correctTextArray.length);
        assertEquals(text[0], correctTextArray[0]);
        assertEquals(text[1], correctTextArray[1]);
        assertEquals("", correctTextArray[2]);
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