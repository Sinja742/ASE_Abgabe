package Controller;

import Entity.Category;
import Entity.CategoryStatus;
import Entity.SimpleCategory;
import jobs.EntityBuilder;
import jobs.TxtHandling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ManageElementTest {

//    private final ManageElement manageElement = mock(ManageElement.class);
    private final TxtHandling txtHandling = mock(TxtHandling.class);
//    private final EntityBuilder entityBuilder = new EntityBuilder(txtHandling);
    private final EntityBuilder entityBuilder = mock(EntityBuilder.class);

    @Test
    void addElementEmptyList() {
        //Given
        ManageElement manageElement = new ManageElement(this.entityBuilder);
        Category element = new SimpleCategory("Element");
        List<Category> arten = new ArrayList<>();

        //When
        when(entityBuilder.readEntity(CategoryStatus.ART)).thenReturn(arten);
        when(entityBuilder.readEntity(CategoryStatus.STIMMUNG)).thenReturn(null);
        when(entityBuilder.readEntity(CategoryStatus.OBJEKT)).thenReturn(null);

        manageElement.addElement(element, CategoryStatus.ART);

        //Then
        assertEquals(element.getDescription(), manageElement.getAllArten().get(0).getDescription());
    }

//    @Test
//    void addElementFillList() {
//        //Given
//        ManageElement manageElement = new ManageElement(this.entityBuilderMock, this.txtHandling);
//        Category element = new SimpleCategory("Element");
////        List<Category> arten = new ArrayList<>();
////        arten.add(new SimpleCategory("ExistingElement"));
//
//        //When
//        when(txtHandling.readTxt()).thenReturn(new String[] {"ExistingElement","",""});
////        when(entityBuilder.readEntity(CategoryStatus.ART)).thenReturn(arten);
////        when(entityBuilder.readEntity(CategoryStatus.STIMMUNG)).thenReturn(null);
////        when(entityBuilder.readEntity(CategoryStatus.OBJEKT)).thenReturn(null);
//
//        manageElement.addElement(element, CategoryStatus.ART);
//
//        //Then
//        assertEquals(2, manageElement.getAllArten().size());
//    }

    @Test
    void deleteSearchElementEmptyList() {
        //Given
        ManageElement manageElement = new ManageElement(this.entityBuilder);
        String description = "element";
        List<Category> elements = new ArrayList<>();

        //When
        List<Category> category = manageElement.deleteSearchElement(description, elements);

        //Then
        assertEquals(0, category.size());
    }

    @Test
    void deleteSearchElementEmptyString() {
        //Given
        ManageElement manageElement = new ManageElement(this.entityBuilder);
        String description = null;
        List<Category> elements = new ArrayList<>();
        elements.add(new SimpleCategory("element"));

        //When
        List<Category> category = manageElement.deleteSearchElement(description, elements);

        //Then
        assertEquals(elements, category);
    }

    @Test
    void deleteSearchElementSuccess() {
        //Given
        ManageElement manageElement = new ManageElement(this.entityBuilder);
        String description = "element";
        List<Category> elements = new ArrayList<>();
        elements.add(new SimpleCategory("element"));

        //When
        List<Category> category = manageElement.deleteSearchElement(description, elements);

        //Then
        assertEquals(0, category.size());
    }

    @Test
    void deleteSearchElementFailure() {
        //Given
        ManageElement manageElement = new ManageElement(this.entityBuilder);
        String description = "element";
        List<Category> elements = new ArrayList<>();
        elements.add(new SimpleCategory("element1"));

        //When
        List<Category> category = manageElement.deleteSearchElement(description, elements);

        //Then
        assertEquals(elements, category);
    }

    @Test
    void searchCategoryToDescriptionEmptyList() {
        //Given
        ManageElement manageElement = new ManageElement(this.entityBuilder);
        String description = "element";
        List<Category> elements = new ArrayList<>();

        //When
        Category category = manageElement.searchCategoryToDescription(description, elements);

        //Then
        assertNull(category);
    }

    @Test
    void searchCategoryToDescriptionEmptyString() {
        //Given
        ManageElement manageElement = new ManageElement(this.entityBuilder);
        String description = null;
        List<Category> elements = new ArrayList<>();
        elements.add(new SimpleCategory("element"));

        //When
        Category category = manageElement.searchCategoryToDescription(description, elements);

        //Then
        assertNull(category);
    }

    @Test
    void searchCategoryToDescriptionSuccess() {
        //Given
        ManageElement manageElement = new ManageElement(this.entityBuilder);
        String description = "element";
        List<Category> elements = new ArrayList<>();
        elements.add(new SimpleCategory("element"));

        //When
        Category category = manageElement.searchCategoryToDescription(description, elements);

        //Then
        assertEquals(description, category.getDescription());
    }

    @Test
    void searchCategoryToDescriptionFailure() {
        //Given
        ManageElement manageElement = new ManageElement(this.entityBuilder);
        String description = "element";
        List<Category> elements = new ArrayList<>();
        elements.add(new SimpleCategory("element1"));

        //When
        Category category = manageElement.searchCategoryToDescription(description, elements);

        //Then
        assertNull(category);
    }

    @Test
    void toArrayEmpty() {
        //Given
        List<Category> list = new ArrayList<>();

        //When
        Category[] array = ManageElement.toArray(list);

        //Then
        assertEquals(0, array.length);
    }

    @Test
    void toArrayFill() {
        //Given
        List<Category> list = new ArrayList<>();
        list.add(new SimpleCategory("element1"));
        list.add(new SimpleCategory("element2"));

        //When
        Category[] array = ManageElement.toArray(list);

        //Then
        assertEquals(2, array.length);
        assertEquals("element1", array[0].getDescription());
        assertEquals("element2", array[1].getDescription());
    }

    @Test
    void toStringListEmpty() {
        //Given
        List<Category> categoryList = new ArrayList<>();

        //When
        List<String> stringList = ManageElement.toStringList(categoryList);

        //Then
        assertEquals(0, stringList.size());
    }

    @Test
    void toStringListFill() {
        //Given
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new SimpleCategory("element1"));
        categoryList.add(new SimpleCategory("element2"));

        //When
        List<String> stringList = ManageElement.toStringList(categoryList);

        //Then
        assertEquals(2, stringList.size());
        assertEquals("element1", stringList.get(0));
        assertEquals("element2", stringList.get(1));
    }
}