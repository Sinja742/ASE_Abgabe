package Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjektTest {

    @Test
    void containsTag_True() {
        Tag[] testFilterTags = {Tag.FANTASIE,Tag.TIER};
        Objekt testObjekt = new Objekt("Test", new Tag[]{Tag.TIER,Tag.FANTASIE});

        boolean returnBoolean = testObjekt.containsTag(testFilterTags);

        assertTrue(returnBoolean);
    }

    @Test
    void containsTag_False() {
        Tag[] testFilterTags = {Tag.FANTASIE,Tag.TIER};
        Objekt testObjekt = new Objekt("Test", new Tag[]{});

        boolean returnBoolean = testObjekt.containsTag(testFilterTags);

        assertFalse(returnBoolean);
    }
}