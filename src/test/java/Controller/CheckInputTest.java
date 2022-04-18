package Controller;

import Entity.CategoryStatus;
import Entity.SimpleCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CheckInputTest {

    private final ManageElement manageElement = mock(ManageElement.class);

    @Test
    void checkCategoriesExistSuccess() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String[] elements = {"Element"};

        //When
        when(manageElement.getCategoryToDescription("Element", CategoryStatus.ART)).thenReturn(new SimpleCategory("Element"));

        boolean exists = checkInput.checkCategoriesExist(elements, CategoryStatus.ART);

        //Then
        assertTrue(exists);
    }

    @Test
    void checkCategoriesExistFailure() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String[] elements = {"Element"};

        //When
        when(manageElement.getCategoryToDescription("Element", CategoryStatus.ART)).thenReturn(null);

        boolean exists = checkInput.checkCategoriesExist(elements, CategoryStatus.ART);

        //Then
        assertFalse(exists);
    }

    @Test
    void checkCategorySuccess() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String element = "Element";

        //When
        when(manageElement.getCategoryToDescription(element, CategoryStatus.ART)).thenReturn(new SimpleCategory(element));

        boolean exists = checkInput.checkCategory(element, CategoryStatus.ART);

        //Then
        assertTrue(exists);
    }

    @Test
    void checkCategoryFailure() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String element = "Element";

        //When
        when(manageElement.getCategoryToDescription(element, CategoryStatus.ART)).thenReturn(null);

        boolean exists = checkInput.checkCategory(element, CategoryStatus.ART);

        //Then
        assertFalse(exists);
    }

    @Test
    void checkTagsExistSuccess() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String[] tags = {"Tier"};

        //When
        boolean exists = checkInput.checkTagsExist(tags);

        //Then
        assertTrue(exists);
    }

    @Test
    void checkTagsExistFailure() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String[] tags = {"Tag"};

        //When
        boolean exists = checkInput.checkTagsExist(tags);

        //Then
        assertFalse(exists);
    }

    @Test
    void checkTagSuccess() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String tag = "Tier";

        //When
        boolean exists = checkInput.checkTag(tag);

        //Then
        assertTrue(exists);
    }

    @Test
    void checkTagFailure() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String tag = "Tag";

        //When
        boolean exists = checkInput.checkTag(tag);

        //Then
        assertFalse(exists);
    }

    @Test
    void elementDoNotExistsSuccess() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String element = "Element";

        //When
        when(manageElement.getCategoryToDescription(element, CategoryStatus.ART)).thenReturn(null);

        boolean exists = checkInput.elementDoNotExists(element, CategoryStatus.ART);

        //Then
        assertTrue(exists);
    }

    @Test
    void elementDoNotExistsFailure() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String element = "Element";

        //When
        when(manageElement.getCategoryToDescription(element, CategoryStatus.ART)).thenReturn(new SimpleCategory(element));

        boolean exists = checkInput.elementDoNotExists(element, CategoryStatus.ART);

        //Then
        assertFalse(exists);
    }
}