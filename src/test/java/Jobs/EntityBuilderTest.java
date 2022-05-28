package Jobs;

import Entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class EntityBuilderTest {

    TxtHandling handlerTxtMock;
    EntityBuilder entityBuilder;

    @BeforeEach
    void setUp() {
        handlerTxtMock = mock(TxtHandling.class);
        entityBuilder = new EntityBuilder(handlerTxtMock);
    }

    @Test
    void readEntity_Objekt() {
//        Given
        CategoryStatus categoryStatus = CategoryStatus.OBJEKT;
        String[] testText = {"art1,art2,art3","stimmung1,stimmung2,stimmun3","objekt1;1;2,objekt2;3;4,objekt3;3;1"};
        List<Category> testList = new ArrayList<>();
        testList.add(new Objekt("objekt1",new Tag[]{Tag.LANDSCHAFT,Tag.GEGENSTAND}));
        testList.add(new Objekt("objekt2",new Tag[]{Tag.FANTASIE,Tag.TIER}));
        testList.add(new Objekt("objekt3",new Tag[]{Tag.FANTASIE,Tag.LANDSCHAFT}));
        when(handlerTxtMock.readTxt()).thenReturn(testText);
//        When
        List<Category> returnCategoryElements = entityBuilder.readEntity(categoryStatus);
//        Then
        assertEquals(testList.size(), returnCategoryElements.size());
        assertEquals(testList.get(0).toString(), returnCategoryElements.get(0).toString());
        assertEquals(testList.get(1).toString(), returnCategoryElements.get(1).toString());
        assertEquals(testList.get(2).toString(), returnCategoryElements.get(2).toString());
    }

    @Test
    void readEntity_SimpleCategory() {
//        Given
        CategoryStatus categoryStatus = CategoryStatus.ART;
        String[] testText = {"art1,art2,art3","stimmung1,stimmung2,stimmun3","objekt1;1;2,objekt2;3;4,objekt3;3;1"};
        List<Category> testList = new ArrayList<>();
        testList.add(new SimpleCategory("art1"));
        testList.add(new SimpleCategory("art2"));
        testList.add(new SimpleCategory("art3"));
        when(handlerTxtMock.readTxt()).thenReturn(testText);
//        When
        List<Category> returnCategoryElements = entityBuilder.readEntity(categoryStatus);
//        Then
        assertEquals(testList.size(), returnCategoryElements.size());
        assertEquals(testList.get(0).toString(), returnCategoryElements.get(0).toString());
        assertEquals(testList.get(1).toString(), returnCategoryElements.get(1).toString());
        assertEquals(testList.get(2).toString(), returnCategoryElements.get(2).toString());
    }

    @Test
    void getEntity() {
//        Given
        CategoryStatus categoryStatus = CategoryStatus.ART;
        String[] testText = {"art1,art2,art3","stimmung1,stimmung2,stimmun3","objekt1;1;2,objekt2;3;4,objekt3;3;1"};
        List<Category> testList = new ArrayList<>();
        testList.add(new SimpleCategory("art1"));
        testList.add(new SimpleCategory("art2"));
        testList.add(new SimpleCategory("art3"));
        when(this.handlerTxtMock.readTxt()).thenReturn(testText);
//        When
        List<Category> returnCategoryElements = entityBuilder.getEntity(categoryStatus);
//        Then
        assertEquals(testList.size(),returnCategoryElements.size());
        assertEquals(testList.get(0).toString(),returnCategoryElements.get(0).toString());
        assertEquals(testList.get(1).toString(),returnCategoryElements.get(1).toString());
        assertEquals(testList.get(2).toString(),returnCategoryElements.get(2).toString());

    }

    @Test
    void getObjekt() {
//        Given
        String[] testText = {"art1,art2,art3","stimmung1,stimmung2,stimmun3","objekt1;1;2,objekt2;3;4,objekt3;3;1"};
        List<Category> testList = new ArrayList<>();
        testList.add(new Objekt("objekt1",new Tag[]{Tag.LANDSCHAFT,Tag.GEGENSTAND}));
        testList.add(new Objekt("objekt2",new Tag[]{Tag.FANTASIE,Tag.TIER}));
        testList.add(new Objekt("objekt3",new Tag[]{Tag.FANTASIE,Tag.LANDSCHAFT}));
        doReturn(testText).when(handlerTxtMock).readTxt();
        when(handlerTxtMock.readTxt()).thenReturn(testText);
//        When
        List<Category> returnCategoryElements = entityBuilder.getObjekt();
//        Then
        assertEquals(testList.size(),returnCategoryElements.size());
        assertEquals(testList.get(0).toString(),returnCategoryElements.get(0).toString());
        assertEquals(testList.get(1).toString(),returnCategoryElements.get(1).toString());
        assertEquals(testList.get(2).toString(),returnCategoryElements.get(2).toString());
    }

    @Test
    void getTags(){
        String[] objekt = {"objekt1","1","2"};
        List<Tag> testList = new ArrayList<>();
        testList.add(Tag.LANDSCHAFT);
        testList.add(Tag.GEGENSTAND);

        List<Tag> tagList = entityBuilder.getTags(objekt);

        assertEquals(testList,tagList);
    }
}