package Controller;

import Entity.CategoryStatus;
import Entity.SimpleCategory;
import Entity.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

        Boolean exists = checkInput.checkCategoriesExist(elements, CategoryStatus.ART);

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

        Boolean exists = checkInput.checkCategoriesExist(elements, CategoryStatus.ART);

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

        Boolean exists = checkInput.checkCategory(element, CategoryStatus.ART);

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

        Boolean exists = checkInput.checkCategory(element, CategoryStatus.ART);

        //Then
        assertFalse(exists);
    }

    @Test
    void checkTagsExistSuccess() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String[] tags = {"Tier"};

        //When
        Boolean exists = checkInput.checkTagsExist(tags);

        //Then
        assertTrue(exists);
    }

    @Test
    void checkTagsExistFailure() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String[] tags = {"Tag"};

        //When
        Boolean exists = checkInput.checkTagsExist(tags);

        //Then
        assertFalse(exists);
    }

    @Test
    void checkTagSuccess() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String tag = "Tier";

        //When
        Boolean exists = checkInput.checkTag(tag);

        //Then
        assertTrue(exists);
    }

    @Test
    void checkTagFailure() {
        //Given
        CheckInput checkInput = new CheckInput(this.manageElement);
        String tag = "Tag";

        //When
        Boolean exists = checkInput.checkTag(tag);

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

        Boolean exists = checkInput.elementDoNotExists(element, CategoryStatus.ART);

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

        Boolean exists = checkInput.elementDoNotExists(element, CategoryStatus.ART);

        //Then
        assertFalse(exists);
    }
}