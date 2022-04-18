package Controller.SearchElements;

import Entity.Category;
import Entity.Objekt;
import Entity.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class FilterObjektIdeaTest {

//    private final FilterObjektIdea filterObjektIdea = mock(FilterObjektIdea.class);

    @Test
    void randomOneAllElementsNullCategory() {
        //Given
        Category[] categoryElement = new Category[0];
        List<Category> allElements = new ArrayList<>();
        allElements.add(new Objekt("Element1", new Tag[0]));

        FilterObjektIdea filterObjektIdea = new FilterObjektIdea(categoryElement, allElements, new Tag[0]);

        //When
        Category category = filterObjektIdea.random();

        //Then
        assertEquals("Element1", category.getDescription());
    }

    @org.junit.jupiter.api.Test
    void randomTwoAllElementsOneCategory() {
        //Given
        Category[] categoryElement = {new Objekt("Element1", new Tag[0])};
        List<Category> allElements = new ArrayList<>();
        allElements.add(new Objekt("Element1", new Tag[0]));
        allElements.add(new Objekt("Element2", new Tag[0]));

        FilterObjektIdea filterObjektIdea = new FilterObjektIdea(categoryElement, allElements, new Tag[0]);

        //When
        Category category = filterObjektIdea.random();

        //Then
        assertEquals("Element1", category.getDescription());
    }

    @org.junit.jupiter.api.Test
    void randomTwoAllElementsTwoCategory() {
        //Given
        Category[] categoryElement = {new Objekt("Element1", new Tag[0]), new Objekt("Element2", new Tag[0])};
        List<Category> allElements = new ArrayList<>();
        allElements.add(new Objekt("Element1", new Tag[0]));
        allElements.add(new Objekt("Element2", new Tag[0]));

        FilterObjektIdea filterObjektIdea = new FilterObjektIdea(categoryElement, allElements, new Tag[0]);

        //When
        Category category = filterObjektIdea.random();

        //Then
        assertTrue(category.getDescription().equals("Element1") || category.getDescription().equals("Element2"));
    }

    @Test
    void filterCategoryElementsSuccess() {
        //Given
        Category[] categoryElements = {new Objekt("Objekt", new Tag[] {Tag.TIER})};
        FilterObjektIdea filterObjektIdea = new FilterObjektIdea(categoryElements, null, new Tag[0]);

        //When
        Category category = filterObjektIdea.filterCategoryElements();

        //Then
        assertEquals("Objekt", category.getDescription());
    }

    @Test
    void filterCategoryElementsFailure() {
        //Given
        Category[] categoryElements = new Category[0];
        FilterObjektIdea filterObjektIdea = new FilterObjektIdea(categoryElements, null, new Tag[0]);

        //When
        Category category = filterObjektIdea.filterCategoryElements();

        //Then
        assertEquals(null, category);
    }

    @Test
    void filterObjekteSuccess() {
        //Given
        Category[] categoryElements = {new Objekt("Objekt1", new Tag[] {Tag.TIER})};
        Tag[] tagFilter = {Tag.TIER};
        FilterObjektIdea filterObjektIdea = new FilterObjektIdea(categoryElements, null, tagFilter);

        //When
        filterObjektIdea.filterObjekte();

        //Then
        assertEquals(categoryElements[0].getDescription(), filterObjektIdea.categoryElements[0].getDescription());
    }

    @Test
    void filterObjekteFailure() {
        //Given
        Category[] categoryElements = {new Objekt("Objekt1", new Tag[] {Tag.TIER})};
        Tag[] tagFilter = {Tag.ABSTRAKT};
        FilterObjektIdea filterObjektIdea = new FilterObjektIdea(categoryElements, null, tagFilter);

        //When
        filterObjektIdea.filterObjekte();

        //Then
        assertEquals(0, filterObjektIdea.categoryElements.length);
    }

    @Test
    void tagFilterExistsSuccess() {
        //Given
        Tag[] tags = {Tag.TIER};
        FilterObjektIdea filterObjektIdea = new FilterObjektIdea(null, null, null);

        //When
        boolean filterExists = filterObjektIdea.tagFilterExists(tags);

        //Then
        assertTrue(filterExists);
    }

    @Test
    void tagFilterExistsFailure() {
        //Given
        Tag[] tags = new Tag[0];
        FilterObjektIdea filterObjektIdea = new FilterObjektIdea(null, null, null);

        //When
        boolean filterExists = filterObjektIdea.tagFilterExists(tags);

        //Then
        assertFalse(filterExists);
    }
}