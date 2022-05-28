package Controller;

import Entity.Category;
import Entity.CategoryStatus;
import Entity.SimpleCategory;
import Jobs.EntityBuilder;
import Jobs.TxtHandling;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ManageElementTest {

    private EntityBuilder entityBuilderMock;
    ManageElement manageElement;

    @BeforeEach
    void setUp() {
        entityBuilderMock = mock(EntityBuilder.class);
        manageElement = new ManageElement(this.entityBuilderMock, mock(TxtHandling.class));
    }

    @Test
    void addElementEmptyList() {
        //Given
        Category element = new SimpleCategory("Element");
        List<Category> arten = new ArrayList<>();

        //When
        when(entityBuilderMock.readEntity(CategoryStatus.ART)).thenReturn(arten);
        when(entityBuilderMock.readEntity(CategoryStatus.STIMMUNG)).thenReturn(null);
        when(entityBuilderMock.readEntity(CategoryStatus.OBJEKT)).thenReturn(null);

        manageElement.addElement(element, CategoryStatus.ART);

        //Then
        assertEquals(element.getDescription(), manageElement.getAllArten().get(0).getDescription());
    }

    @Test
    void deleteSearchElementEmptyList() {
        //Given
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