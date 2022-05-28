package Entity;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TagTest {

    @Test
    void getTag_Id() {
        Tag returnTag = Tag.getTag(4);

        assertEquals(Tag.TIER, returnTag);
    }

    @Test
    void getTag_Decsription() {
        Tag returnTag = Tag.getTag("Tier");

        assertEquals(Tag.TIER, returnTag);
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