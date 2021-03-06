package Entity;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TagTest {

    @Test
    void getTag_Id_True() {
        Tag returnTag = Tag.getTag(4);

        assertEquals(Tag.TIER, returnTag);
    }

    @Test
    void getTag_Id_False() {
        Tag returnTag = Tag.getTag(42);

        assertNull(returnTag);
    }

    @Test
    void getTag_Decsription_True() {
        Tag returnTag = Tag.getTag("Tier");

        assertEquals(Tag.TIER, returnTag);
    }

    @Test
    void getTag_Decsription_False() {
        Tag returnTag = Tag.getTag("Holz");

        assertNull(returnTag);
    }

    @Test
    void tagsToStringList() {
        List<Tag> testTagList = Collections.singletonList(Tag.FANTASIE);
        List<String> returnTestStringList = Collections.singletonList("Fantasie");

        List<String> returnTagStringList = Tag.tagsToStringList(testTagList);

        assertEquals(1, returnTagStringList.size());
        assertEquals(returnTestStringList, returnTagStringList);
    }
}