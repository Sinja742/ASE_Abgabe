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

    private final GUI guiMock = mock(GUI.class);
    private final SearchElements searchElementsMock = mock(SearchElements.class);
    private final CheckInput checkInputMock = mock(CheckInput.class);
    private final ManageElement manageElementMock = mock(ManageElement.class);

    private SearchElements searchElements = new SearchElements(this.guiMock, this.manageElementMock);

    @Test
    void getSearchElementsTrue() {
        //Given
        List<Category> allElements = new ArrayList<>();
        allElements.add(new SimpleCategory("Category"));

        //When
        when(this.guiMock.trueBooleanQuestion("Wollen Sie nach Arten suchen?")).thenReturn(true);
        when(this.guiMock.getStringArrayOfElements(CategoryStatus.ART, allElements, "Geben Sie die gewünschten Arten ein: ")).thenReturn(new String[] {"Category"});
        when(this.checkInputMock.checkCategoriesExist(new String[] {"Category"}, CategoryStatus.ART)).thenReturn(true);
        when(this.manageElementMock.getCategoryToDescription("Category", CategoryStatus.ART)).thenReturn(new SimpleCategory("Category"));

        Category[] category = searchElements.getSearchElements(CategoryStatus.ART, allElements);

        //Then
        assertEquals("Category", category[0].getDescription());
    }

    @Test
    void getSearchElementsFalse() {
        //Given

        //When
        when(this.guiMock.trueBooleanQuestion("Wollen Sie nach Arten suchen?")).thenReturn(false);
        when(this.searchElementsMock.getFilters(CategoryStatus.ART, null)).thenReturn(new Category[0]);

        Category[] category = searchElements.getSearchElements(CategoryStatus.ART, null);

        //Then
        assertEquals(0, category.length);
    }

    @Test
    void getSearchTagsTrue() {
        //Given

        //When
        when(this.guiMock.trueBooleanQuestion("Wollen Sie nach Tags suchen?")).thenReturn(true);
        when(this.guiMock.getTags()).thenReturn(new Tag[] {Tag.TIER});

        Tag[] tags = searchElements.getSearchTags();

        //Then
        assertEquals(Tag.TIER, tags[0]);
    }

    @Test
    void getSearchTagsFalse() {
        //Given

        //When
        when(this.guiMock.trueBooleanQuestion("Wollen Sie nach Tags suchen?")).thenReturn(false);
        when(this.guiMock.getTags()).thenReturn(new Tag[0]);

        Tag[] tags = searchElements.getSearchTags();

        //Then
        assertEquals(0, tags.length);
    }

    @Test
    void getFilters() {
        //Given

        //When
        when(this.guiMock.getStringArrayOfElements(CategoryStatus.ART, null, "Geben Sie die gewünschten Arten ein: ")).thenReturn(new String[] {"CategoryDescription"});
        when(this.checkInputMock.checkCategoriesExist(new String[] {"CategoryDescription"}, CategoryStatus.ART)).thenReturn(true);
        when(this.manageElementMock.getCategoryToDescription("CategoryDescription", CategoryStatus.ART)).thenReturn(new SimpleCategory("CategoryDescription"));

        Category[] filters = searchElements.getFilters(CategoryStatus.ART, null);

        //Then
        assertEquals("CategoryDescription", filters[0].getDescription());
    }
}