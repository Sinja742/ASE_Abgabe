package Controller;

import Entity.Category;
import Entity.CategoryStatus;
import Entity.SimpleCategory;
import jobs.EntityBuilder;
import jobs.TxtHandling;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ManageElementTest {

//    private final ManageElement manageElement = mock(ManageElement.class);
    private final TxtHandling txtHandling = mock(TxtHandling.class);
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

    @Test
    void addElementFillList() {
        //Given
        ManageElement manageElement = new ManageElement(this.entityBuilder);
        Category element = new SimpleCategory("Element");
        List<Category> arten = new ArrayList<>();
        arten.add(new SimpleCategory("ExistingElement"));

        //When
        when(entityBuilder.readEntity(CategoryStatus.ART)).thenReturn(arten);
        when(entityBuilder.readEntity(CategoryStatus.STIMMUNG)).thenReturn(null);
        when(entityBuilder.readEntity(CategoryStatus.OBJEKT)).thenReturn(null);

        manageElement.addElement(element, CategoryStatus.ART);

        //Then
        assertEquals(2, manageElement.getAllArten().size());
    }

    @Test
    void deleteElement() {
    }

    @Test
    void deleteSearchElement() {
    }

    @Test
    void getCategoryToDescription() {
    }

    @Test
    void searchCategoryToDescription() {
    }

    @Test
    void toArray() {
    }

    @Test
    void toStringList() {
    }
}