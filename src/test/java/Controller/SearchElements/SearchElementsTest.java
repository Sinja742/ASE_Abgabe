package Controller.SearchElements;

import Controller.CheckInput;
import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.SimpleCategory;
import Entity.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SearchElementsTest {

    private final GUI gui = mock(GUI.class);
    private final SearchElements searchElements = mock(SearchElements.class);
    private final CheckInput checkInput = mock(CheckInput.class);
    private final ManageElement manageElement = mock(ManageElement.class);

    @Test
    void getSearchElementsTrue() {
        //Given
        List<Category> allElements = new ArrayList<>();
        allElements.add(new SimpleCategory("Category"));
        SearchElements searchElements = new SearchElements(this.gui, this.manageElement);

        //When
        when(this.gui.trueBooleanQuestion("Wollen Sie nach Arten suchen?")).thenReturn(true);
        when(this.searchElements.getFilters(CategoryStatus.ART, allElements)).thenReturn(new Category[]{new SimpleCategory("Category")});

        Category[] category = searchElements.getSearchElements(CategoryStatus.ART, allElements);

        //Then
        assertEquals("Category", category[0].getDescription());
    }

    @Test
    void getSearchElementsFalse() {
        //Given
        SearchElements searchElements = new SearchElements(this.gui, null);

        //When
        when(this.gui.trueBooleanQuestion("Wollen Sie nach Arten suchen?")).thenReturn(false);
        when(this.searchElements.getFilters(CategoryStatus.ART, null)).thenReturn(new Category[0]);

        Category[] category = searchElements.getSearchElements(CategoryStatus.ART, null);

        //Then
        assertEquals(0, category.length);
    }

    @Test
    void getSearchTagsTrue() {
        //Given
        SearchElements searchElements = new SearchElements(this.gui, null);

        //When
        when(this.gui.trueBooleanQuestion("Wollen Sie nach Tags suchen?")).thenReturn(true);
        when(this.gui.getTags()).thenReturn(new Tag[] {Tag.TIER});

        Tag[] tags = searchElements.getSearchTags();

        //Then
        assertEquals(Tag.TIER, tags[0]);
    }

    @Test
    void getSearchTagsFalse() {
        //Given
        SearchElements searchElements = new SearchElements(this.gui, null);

        //When
        when(this.gui.trueBooleanQuestion("Wollen Sie nach Tags suchen?")).thenReturn(false);
        when(this.gui.getTags()).thenReturn(new Tag[0]);

        Tag[] tags = searchElements.getSearchTags();

        //Then
        assertEquals(0, tags.length);
    }

    @Test
    void getFilters() {
        //Given
        SearchElements searchElements = new SearchElements(this.gui, this.manageElement);

        //When
        when(this.gui.getStringArrayOfElements(CategoryStatus.ART, null, "Geben Sie die gewünschten Arten ein: ")).thenReturn(new String[] {"CategoryDescription"});
        when(this.checkInput.checkCategoriesExist(new String[] {"CategoryDescription"}, CategoryStatus.ART)).thenReturn(true);
        when(this.manageElement.getCategoryToDescription("CategoryDescription", CategoryStatus.ART)).thenReturn(new SimpleCategory("CategoryDescription"));

        Category[] filters = searchElements.getFilters(CategoryStatus.ART, null);

        //Then
        assertEquals("CategoryDescription", filters[0].getDescription());
    }
}