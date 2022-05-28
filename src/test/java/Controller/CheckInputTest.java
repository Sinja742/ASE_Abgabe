package Controller;

import Entity.CategoryStatus;
import Entity.SimpleCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CheckInputTest {

    private ManageElement manageElementMock;
    private CheckInput checkInput;

    @BeforeEach
    void setUp() {
        manageElementMock = mock(ManageElement.class);
        checkInput = new CheckInput(this.manageElementMock);
    }

    @Test
    void checkCategoriesExistSuccess() {
        //Given
        String[] elements = {"Element"};

        //When
        when(manageElementMock.getCategoryToDescription("Element", CategoryStatus.ART)).thenReturn(new SimpleCategory("Element"));

        boolean exists = checkInput.checkCategoriesExist(elements, CategoryStatus.ART);

        //Then
        assertTrue(exists);
    }

    @Test
    void checkCategoriesExistFailure() {
        //Given
        String[] elements = {"Element"};

        //When
        when(manageElementMock.getCategoryToDescription("Element", CategoryStatus.ART)).thenReturn(null);

        boolean exists = checkInput.checkCategoriesExist(elements, CategoryStatus.ART);

        //Then
        assertFalse(exists);
    }

    @Test
    void checkCategorySuccess() {
        //Given
        String element = "Element";

        //When
        when(manageElementMock.getCategoryToDescription(element, CategoryStatus.ART)).thenReturn(new SimpleCategory(element));

        boolean exists = checkInput.checkCategory(element, CategoryStatus.ART);

        //Then
        assertTrue(exists);
    }

    @Test
    void checkCategoryFailure() {
        //Given
        String element = "Element";

        //When
        when(manageElementMock.getCategoryToDescription(element, CategoryStatus.ART)).thenReturn(null);

        boolean exists = checkInput.checkCategory(element, CategoryStatus.ART);

        //Then
        assertFalse(exists);
    }

    @Test
    void checkTagsExistSuccess() {
        //Given
        String[] tags = {"Tier"};

        //When
        boolean exists = checkInput.checkTagsExist(tags);

        //Then
        assertTrue(exists);
    }

    @Test
    void checkTagsExistFailure() {
        //Given
        String[] tags = {"Tag"};

        //When
        boolean exists = checkInput.checkTagsExist(tags);

        //Then
        assertFalse(exists);
    }

    @Test
    void checkTagSuccess() {
        //Given
        String tag = "Tier";

        //When
        boolean exists = checkInput.checkTag(tag);

        //Then
        assertTrue(exists);
    }

    @Test
    void checkTagFailure() {
        //Given
        String tag = "Tag";

        //When
        boolean exists = checkInput.checkTag(tag);

        //Then
        assertFalse(exists);
    }

    @Test
    void elementDoNotExistsSuccess() {
        //Given
        String element = "Element";

        //When
        when(manageElementMock.getCategoryToDescription(element, CategoryStatus.ART)).thenReturn(null);

        boolean exists = checkInput.elementDoNotExists(element, CategoryStatus.ART);

        //Then
        assertTrue(exists);
    }

    @Test
    void elementDoNotExistsFailure() {
        //Given
        String element = "Element";

        //When
        when(manageElementMock.getCategoryToDescription(element, CategoryStatus.ART)).thenReturn(new SimpleCategory(element));

        boolean exists = checkInput.elementDoNotExists(element, CategoryStatus.ART);

        //Then
        assertFalse(exists);
    }
}