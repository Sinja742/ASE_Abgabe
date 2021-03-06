package Controller.SearchElements;

import Entity.Category;
import Entity.SimpleCategory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FilterIdeaTest {

    @Test
    void randomOneAllElementsNullCategory() {
        //Given
        Category[] categoryElement = new Category[0];
        List<Category> allElements = new ArrayList<>();
        allElements.add(new SimpleCategory("Element1"));

        FilterIdea filterIdea = new FilterIdea(categoryElement, allElements);

        //When
        Category category = filterIdea.random();

        //Then
        assertEquals("Element1", category.getDescription());
    }

    @Test
    void randomTwoAllElementsOneCategory() {
        //Given
        Category[] categoryElement = {new SimpleCategory("Element1")};
        List<Category> allElements = new ArrayList<>();
        allElements.add(new SimpleCategory("Element1"));
        allElements.add(new SimpleCategory("Element2"));

        FilterIdea filterIdea = new FilterIdea(categoryElement, allElements);

        //When
        Category category = filterIdea.random();

        //Then
        assertEquals("Element1", category.getDescription());
    }

    @Test
    void randomTwoAllElementsTwoCategory() {
        //Given
        Category[] categoryElement = {new SimpleCategory("Element1"), new SimpleCategory("Element2")};
        List<Category> allElements = new ArrayList<>();
        allElements.add(new SimpleCategory("Element1"));
        allElements.add(new SimpleCategory("Element2"));

        FilterIdea filterIdea = new FilterIdea(categoryElement, allElements);

        //When
        Category category = filterIdea.random();

        //Then
        assertTrue(category.getDescription().equals("Element1") || category.getDescription().equals("Element2"));
    }
}