package Controller.SearchElements;

import Entity.Category;
import Entity.SimpleCategory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FilterTest {

    @Test
    void fillCategoryElementsIfEmpty() {
        //Given
        List<Category> allElements = new ArrayList<>();
        allElements.add(new SimpleCategory("Element1"));
        FilterIdea filterIdea = new FilterIdea(new Category[0], allElements);

        //When
        filterIdea.fillCategoryElementsIfEmpty();

        //Then
        assertEquals(1, filterIdea.categoryElements.length);
    }

    @Test
    void noFilterElementsSuccess() {
        //Given
        Category[] filter = new Category[0];
        FilterIdea filterIdea = new FilterIdea(null, null);

        //When
        boolean noFilterElement = filterIdea.noFilterElements(filter);

        //Then
        assertTrue(noFilterElement);
    }

    @Test
    void noFilterElementsFailure() {
        //Given
        Category[] filter = {new SimpleCategory("Category")};
        FilterIdea filterIdea = new FilterIdea(null, null);

        //When
        boolean noFilterElement = filterIdea.noFilterElements(filter);

        //Then
        assertFalse(noFilterElement);
    }
}